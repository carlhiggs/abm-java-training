package uk.cam.mrc.phm.training.day2.fabiland.models;

import cern.colt.map.tfloat.OpenIntFloatHashMap;
import com.google.common.collect.Iterables;
import com.google.common.math.LongMath;
import de.tum.bgu.msm.container.DataContainer;
import de.tum.bgu.msm.data.*;
import de.tum.bgu.msm.data.person.Person;
import de.tum.bgu.msm.health.airPollutant.AirPollutantModel;
import de.tum.bgu.msm.health.data.*;
import de.tum.bgu.msm.models.AbstractModel;
import de.tum.bgu.msm.models.ModelUpdateListener;
import de.tum.bgu.msm.properties.Properties;
import de.tum.bgu.msm.util.concurrent.ConcurrentExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.network.Link;
import org.matsim.api.core.v01.network.Node;
import org.matsim.api.core.v01.population.PopulationFactory;
import org.matsim.contrib.dvrp.trafficmonitoring.TravelTimeUtils;
import org.matsim.contrib.emissions.Pollutant;
import org.matsim.core.config.Config;
import org.matsim.core.controler.ControlerDefaults;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.network.io.MatsimNetworkReader;
import org.matsim.core.population.PopulationUtils;
import org.matsim.core.router.speedy.SpeedyALTFactory;
import org.matsim.core.router.util.LeastCostPathCalculator;
import org.matsim.core.router.util.TravelDisutility;
import org.matsim.core.router.util.TravelTime;
import org.matsim.core.scenario.MutableScenario;
import org.matsim.core.scenario.ScenarioUtils;
import uk.cam.mrc.phm.training.day2.fabiland.data.Trip;
import uk.cam.mrc.phm.training.day2.fabiland.io.TripReader;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class FabilandHealthExposureModel extends AbstractModel implements ModelUpdateListener {
    private int latestMatsimYear = -1;
    private static final Logger logger = LogManager.getLogger(FabilandHealthExposureModel.class);
    private Map<Integer, Trip> trips = new HashMap<>();
    private final Config initialMatsimConfig;
    private MutableScenario scenario;

    public FabilandHealthExposureModel(DataContainer dataContainer, Properties properties, Random random, Config config) {
        super(dataContainer, properties, random);
        this.initialMatsimConfig = config;
    }

    @Override
    public void setup() { }

    @Override
    public void prepareYear(int year) {}

    @Override
    public void endYear(int year) {
        if(properties.main.startYear == year || properties.transportModel.transportModelYears.contains(year)) {
            logger.warn("Health model end year:" + year);
            latestMatsimYear = year;

            String outputDirectoryRoot = properties.main.baseDirectory + "scenOutput/"
                    + properties.main.scenarioName + "/matsim/" + latestMatsimYear;


            Map<Integer, Trip> allTrips = new TripReader().readData(outputDirectoryRoot + "/" + year + ".output_trips.csv.gz");

            //clear the health data from last exposure model year
            for(Person person : dataContainer.getHouseholdDataManager().getPersons()) {
                ((PersonHealth) person).resetHealthData();
            }

            logger.warn("Run health exposure model ");

            for(String mode : Arrays.asList("car","walk")){
                trips = allTrips.values().stream().
                        filter(trip -> trip.getTripMode().equals(mode)).
                        collect(Collectors.toMap(Trip::getId,trip -> trip));
                healthDataAssembler(latestMatsimYear, mode);
                calculatePersonHealthExposures();
            }

            calculatePersonHealthExposuresAtHome();
        }

    }

    @Override
    public void endSimulation() {
    }

    private void healthDataAssembler(int year, String mode) {
        logger.info("Updating health data for year " + year + "|mode: " + mode + ".");

        final String outputDirectoryRoot = properties.main.baseDirectory + "scenOutput/"
                + properties.main.scenarioName + "/matsim/" + latestMatsimYear;

        scenario = ScenarioUtils.createMutableScenario(initialMatsimConfig);
        scenario.getConfig().routing().setRoutingRandomness(0);
        scenario.getConfig().controller().setOutputDirectory(outputDirectoryRoot);

        calculateTripHealthIndicator(new ArrayList<>(trips.values()), mode);
    }

    private void calculateTripHealthIndicator(List<Trip> trips, String mode) {
        logger.info("Updating trip health data for mode " + mode);

        final int partitionSize = (int) ((double) trips.size() / Runtime.getRuntime().availableProcessors()) + 1;
        Iterable<List<Trip>> partitions = Iterables.partition(trips, partitionSize);

        TravelTime travelTime;
        TravelDisutility travelDisutility;
        String networkFile;


        String eventsFile = scenario.getConfig().controller().getOutputDirectory() + "/" + latestMatsimYear + ".output_events.xml.gz";
        networkFile = scenario.getConfig().controller().getOutputDirectory() + "/" + latestMatsimYear + ".output_network.xml.gz";
        new MatsimNetworkReader(scenario.getNetwork()).readFile(networkFile);
        travelTime = TravelTimeUtils.createTravelTimesFromEvents(scenario.getNetwork(),scenario.getConfig(), eventsFile);
        travelDisutility = ControlerDefaults.createDefaultTravelDisutilityFactory(scenario).createTravelDisutility(travelTime);


        ConcurrentExecutor<Void> executor = ConcurrentExecutor.fixedPoolService(Runtime.getRuntime().availableProcessors());

        AtomicInteger counter = new AtomicInteger();
        logger.info("Partition Size: " + partitionSize);

        AtomicInteger NO_PATH_TRIP = new AtomicInteger();

        for (final List<Trip> partition : partitions) {
            LeastCostPathCalculator pathCalculator = new SpeedyALTFactory().createPathCalculator(scenario.getNetwork(),travelDisutility,travelTime);
            PopulationFactory factory = PopulationUtils.getFactory();
            executor.addTaskToQueue(() -> {
                try {

                    int id = counter.incrementAndGet();
                    int counterr = 0;
                    for (Trip trip : partition) {

                        if(LongMath.isPowerOfTwo(counterr)) {
                            logger.info(counterr + " in " + id);
                        }

                        Node originNode = NetworkUtils.getNearestNode(scenario.getNetwork(), trip.getTripOrigin());
                        Node destinationNode = NetworkUtils.getNearestNode(scenario.getNetwork(), trip.getTripDestination());

                        int outboundDepartureTimeInSeconds = trip.getDepartureTimeInMinutes()*60;
                        org.matsim.api.core.v01.population.Person person = factory.createPerson(Id.createPersonId(trip.getId()));


                        LeastCostPathCalculator.Path outboundPath = pathCalculator.calcLeastCostPath(originNode, destinationNode,outboundDepartureTimeInSeconds,person,null);
                        if(outboundPath == null){
                            logger.warn("trip id: " + trip.getId() + ", trip depart time: " + trip.getDepartureTimeInMinutes() +
                                    "origin coord: [" + trip.getTripOrigin().getX() + "," + trip.getTripOrigin().getY() + "], " +
                                    "dest coord: [" + trip.getTripDestination().getX() + "," + trip.getTripDestination().getY() + "], " +
                                    "origin node: " + originNode + ", dest node: " + destinationNode);
                            NO_PATH_TRIP.getAndIncrement();
                        } else {
                            calculatePathExposures(trip,outboundPath,outboundDepartureTimeInSeconds,travelTime);
                        }

                        counterr++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.warn(e.getLocalizedMessage());
                    throw new RuntimeException(e);
                }
                return null;
            });
        }
        executor.execute();

        logger.info("No path trips for mode " + mode + " : " + NO_PATH_TRIP.get());

    }

    private void calculatePathExposures(Trip trip,LeastCostPathCalculator.Path path,int departureTimeInSecond, TravelTime travelTime) {

        Mode mode = trip.getTripMode().equals("car")? Mode.autoDriver : Mode.walk;
        Double speed = null;
        if(mode.equals(Mode.walk)) {
            speed = getAvgWalkSpeed((PersonHealth) dataContainer.getHouseholdDataManager().getPersonFromId(trip.getPerson()));
        } else if(mode.equals(Mode.bicycle)) {
            speed = getAvgCycleSpeed((PersonHealth) dataContainer.getHouseholdDataManager().getPersonFromId(trip.getPerson()));
        }
        double enterTimeInSecond;
        double pathLength = 0;
        double pathTime = 0;
        double pathMarginalMetHours = 0;
        double pathConcMetersPm25 = 0.;
        double pathConcMetersNo2 = 0.;
        double pathExposurePm25 = 0.;
        double pathExposureNo2 = 0.;
        double pathSevereInjuryRisk = 0;
        double pathFatalityRisk = 0;

        for(Link link : path.links) {
            enterTimeInSecond = (double) departureTimeInSecond + pathTime;
            double linkLength = link.getLength();
            double linkSevereInjuryRisk = 0.;
            double linkFatalityRisk = 0.;
            double linkMarginalMetHours = 0.;
            double linkConcentrationPm25 = 0.;
            double linkConcentrationNo2 = 0.;
            double linkExposurePm25 = 0.;
            double linkExposureNo2 = 0.;

            double linkTime;
            if(mode.equals(Mode.walk) || mode.equals(Mode.bicycle)) {
                linkTime = linkLength / speed;
            } else {
                linkTime = travelTime.getLinkTravelTime(link, enterTimeInSecond, null, null);
            }

            LinkInfo linkInfo = ((DataContainerHealth)dataContainer).getLinkInfo().get(link.getId());
            if(linkInfo!=null) {
                // PHYSICAL ACTIVITY
                double linkMarginalMet = PhysicalActivity.getMMet(mode, linkLength, linkTime, link);
                //TODO: convert matsim link time to moving only
                linkMarginalMetHours = linkMarginalMet * linkTime / 3600.;

                // AIR POLLUTION Concentration
                int timeBin = (int) (AirPollutantModel.EMISSION_TIME_BIN_SIZE*(Math.floor(Math.abs(enterTimeInSecond/AirPollutantModel.EMISSION_TIME_BIN_SIZE))));
                linkConcentrationPm25 = linkInfo.getExposure2Pollutant2TimeBin().getOrDefault(Pollutant.PM2_5,new OpenIntFloatHashMap()).get(timeBin) +
                        linkInfo.getExposure2Pollutant2TimeBin().getOrDefault(Pollutant.PM2_5_non_exhaust,new OpenIntFloatHashMap()).get(timeBin);
                linkConcentrationNo2 = linkInfo.getExposure2Pollutant2TimeBin().getOrDefault(Pollutant.NO2,new OpenIntFloatHashMap()).get(timeBin);

                linkExposurePm25 = PollutionExposure.getLinkExposurePm25(mode, linkConcentrationPm25, linkTime, linkMarginalMet);
                linkExposureNo2 = PollutionExposure.getLinkExposureNo2(mode, linkConcentrationPm25, linkTime, linkMarginalMet);
            }

            pathLength += linkLength;
            pathTime += linkTime;
            pathSevereInjuryRisk += linkSevereInjuryRisk - (pathSevereInjuryRisk * linkSevereInjuryRisk);
            pathFatalityRisk += linkFatalityRisk - (pathFatalityRisk * linkFatalityRisk);
            pathMarginalMetHours += linkMarginalMetHours;
            pathConcMetersPm25 += linkConcentrationPm25 * linkLength;
            pathConcMetersNo2 += linkConcentrationNo2 * linkLength;
            pathExposurePm25 += linkExposurePm25;
            pathExposureNo2 += linkExposureNo2;
        }

        Map<String, Float> accidentRiskMap = new HashMap<>();
        accidentRiskMap.put("severeInjury", (float) pathSevereInjuryRisk);
        accidentRiskMap.put("fatality", (float) pathFatalityRisk);

        Map<String, Float> exposureMap = new HashMap<>();
        exposureMap.put("pm2.5", (float) pathExposurePm25);
        exposureMap.put("no2", (float) pathExposureNo2);

        trip.updateMatsimTravelDistance(pathLength);
        trip.updateMatsimTravelTime(pathTime);
        trip.updateMarginalMetHours(pathMarginalMetHours);
        trip.updateTravelRiskMap(accidentRiskMap);
        trip.updateTravelExposureMap(exposureMap);
        trip.updateMatsimLinkCount(path.links.size());
        trip.updateMatsimConcMetersPm25(pathConcMetersPm25);
        trip.updateMatsimConcMetersNo2(pathConcMetersNo2);
    }

    private void calculateActivityExposures(Trip trip) {
        double activityArrivalTime = trip.getDepartureTimeInMinutes() + trip.getMatsimTravelTime()/60.;
        double activityDepartureTime = activityArrivalTime + 8 * 60;
        double activityDuration = activityDepartureTime - activityArrivalTime;
        if(activityDuration < 0) {
            activityDuration += 1440.;
        }

        int timeBin = (int) (AirPollutantModel.EMISSION_TIME_BIN_SIZE*(Math.floor(Math.abs(activityArrivalTime/AirPollutantModel.EMISSION_TIME_BIN_SIZE))));

        //job zone
        int jobId = dataContainer.getHouseholdDataManager().getPersonFromId(trip.getPerson()).getJobId();
        int zoneId = dataContainer.getJobDataManager().getJobFromId(jobId).getZoneId();
        Zone zone = dataContainer.getGeoData().getZones().get(zoneId);
        double zonalIncrementalPM25 = ((DataContainerHealth)dataContainer).getZoneExposure2Pollutant2TimeBin().get(zone).get(Pollutant.PM2_5).get(timeBin)+
                ((DataContainerHealth)dataContainer).getZoneExposure2Pollutant2TimeBin().get(zone).get(Pollutant.PM2_5_non_exhaust).get(timeBin);
        double zonalIncrementalNO2 = ((DataContainerHealth)dataContainer).getZoneExposure2Pollutant2TimeBin().get(zone).get(Pollutant.NO2).get(timeBin);

        // todo: consider location-specific exposures & occupation-specific METs for work activities
        Map<String, Float> exposureMap = new HashMap<>();
        exposureMap.put("pm2.5", (float) PollutionExposure.getActivityExposurePm25(activityDuration, zonalIncrementalPM25));
        exposureMap.put("no2", (float) PollutionExposure.getActivityExposureNo2(activityDuration, zonalIncrementalNO2));

        trip.setActivityDuration(activityDuration);
        trip.setActivityExposureMap(exposureMap);
    }

    //TODO: concurrent
    private void calculatePersonHealthExposures() {
        int missingPerson = 0;
        for(Trip trip :  trips.values()){
            Person siloPerson = dataContainer.getHouseholdDataManager().getPersonFromId(trip.getPerson());
            if(siloPerson == null){
                missingPerson++;
                continue;
            }

            ((PersonHealth) siloPerson).updateWeeklyAccidentRisks(trip.getTravelRiskMap());
            ((PersonHealth) siloPerson).updateWeeklyMarginalMetHours(trip.getTripMode().equals("car")? Mode.autoDriver : Mode.walk, (float) trip.getMarginalMetHours());
            ((PersonHealth) siloPerson).updateWeeklyPollutionExposures(trip.getTravelExposureMap());
            ((PersonHealth) siloPerson).updateWeeklyTravelSeconds((float) trip.getMatsimTravelTime());

            // Activity details (home-based trips only)
            ((PersonHealth) siloPerson).updateWeeklyActivityMinutes((float) trip.getActivityDuration());
            ((PersonHealth) siloPerson).updateWeeklyPollutionExposures(trip.getActivityExposureMap());

        }
        logger.warn("total dismatched person: " + missingPerson);
    }

    private void calculatePersonHealthExposuresAtHome() {
        for(Person person : dataContainer.getHouseholdDataManager().getPersons()) {
            double minutesAtHome = Math.max(0., 10080. - (((PersonHealth) person).getWeeklyTravelSeconds() / 60.) - (((PersonHealth) person).getWeeklyActivityMinutes()));

            //TODO: check, assume people usually at home at night (6 pm?)
            int timeBin = (int) (AirPollutantModel.EMISSION_TIME_BIN_SIZE*(Math.floor(Math.abs(3600*18/AirPollutantModel.EMISSION_TIME_BIN_SIZE))));

            int zoneId = dataContainer.getRealEstateDataManager().getDwelling(person.getHousehold().getDwellingId()).getZoneId();
            Zone zone = dataContainer.getGeoData().getZones().get(zoneId);
            double zonalIncrementalPM25 = ((DataContainerHealth)dataContainer).getZoneExposure2Pollutant2TimeBin().get(zone).get(Pollutant.PM2_5).get(timeBin)+
                    ((DataContainerHealth)dataContainer).getZoneExposure2Pollutant2TimeBin().get(zone).get(Pollutant.PM2_5_non_exhaust).get(timeBin);
            double zonalIncrementalNO2 = ((DataContainerHealth)dataContainer).getZoneExposure2Pollutant2TimeBin().get(zone).get(Pollutant.NO2).get(timeBin);


            Map<String, Float> exposureMap = new HashMap<>();
            exposureMap.put("pm2.5", (float) PollutionExposure.getHomeExposurePm25(minutesAtHome, zonalIncrementalPM25));
            exposureMap.put("no2", (float) PollutionExposure.getHomeExposureNo2(minutesAtHome, zonalIncrementalNO2));

            ((PersonHealth) person).setWeeklyHomeMinutes((float) minutesAtHome);
            ((PersonHealth) person).updateWeeklyPollutionExposures(exposureMap);
        }
    }

    private double getAvgCycleSpeed(PersonHealth person) {
        return ((DataContainerHealth)dataContainer).getAvgSpeeds().get(Mode.bicycle).
                get(MitoGender.valueOf(person.getGender().name())).get(Math.min(person.getAge(),105)) / 3.6;
    }

    private double getAvgWalkSpeed(PersonHealth person) {
        return ((DataContainerHealth)dataContainer).getAvgSpeeds().get(Mode.walk).
                get(MitoGender.valueOf(person.getGender().name())).get(Math.min(person.getAge(),105)) / 3.6;
    }

}
