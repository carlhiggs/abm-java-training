package uk.cam.mrc.phm.training.day2.fabiland.io;

import de.tum.bgu.msm.data.Mode;
import de.tum.bgu.msm.utils.SiloUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.matsim.api.core.v01.TransportMode;
import org.matsim.core.utils.geometry.CoordUtils;
import uk.cam.mrc.phm.training.day2.fabiland.data.Trip;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class TripReader {

    private final static Logger logger = LogManager.getLogger(TripReader.class);


    public Map<Integer, Trip> readData(String path) {
        logger.info("Reading trip data from matsim trip csv file");
        Map<Integer, Trip> allTrips = new HashMap<>();

        String recString = "";
        int recCount = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);
            BufferedReader in = new BufferedReader(new InputStreamReader(gzipInputStream));

            recString = in.readLine();

            // read header
            String[] header = recString.split(";");
            int posOriginX = SiloUtil.findPositionInArray("start_x", header);
            int posOriginY = SiloUtil.findPositionInArray("start_y", header);
            int posDestinationX = SiloUtil.findPositionInArray("end_x", header);
            int posDestinationY = SiloUtil.findPositionInArray("end_y", header);

            int posMode = SiloUtil.findPositionInArray("main_mode", header);
            int posPerson = SiloUtil.findPositionInArray("person", header);
            int posDepartureTime = SiloUtil.findPositionInArray("dep_time", header);

            // read line
            while ((recString = in.readLine()) != null) {
                recCount++;
                String[] lineElements = recString.split(";");

                Trip trip;
                if(!allTrips.containsKey(recCount)) {
                    trip = new Trip(recCount);
                }else{
                    logger.warn("Trip id: " + recCount + " already exists in the trip list!");
                    continue;
                }

                if(lineElements[posOriginX].equals("null")||lineElements[posDestinationX].equals("null")){
                    logger.warn("trip id: " + recCount + "no origin or destination microlocation!");
                }

                trip.setTripOrigin(CoordUtils.createCoord(Double.parseDouble(lineElements[posOriginX]),Double.parseDouble(lineElements[posOriginY])));
                trip.setTripDestination(CoordUtils.createCoord(Double.parseDouble(lineElements[posDestinationX]),Double.parseDouble(lineElements[posDestinationY])));

                trip.setTripMode(lineElements[posMode]);
                trip.setPerson(Integer.parseInt(lineElements[posPerson]));

                String[] timeParts = lineElements[posDepartureTime].split(":");

                // Parse the hours, minutes, and seconds to integers
                int hours = Integer.parseInt(timeParts[0]);
                int minutes = Integer.parseInt(timeParts[1]);

                // Calculate total minutes (hours * 60 + minutes)
                int totalMinutes = hours * 60 + minutes;

                trip.setDepartureInMinutes(totalMinutes);

                allTrips.put(recCount,trip);
            }

            // Close the reader after usage
            in.close();
            gzipInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            logger.fatal("IO Exception caught reading mito trip file: " + path);
            logger.fatal("recCount = " + recCount + ", recString = <" + recString + ">");
        }
        logger.info("Finished reading " + recCount + " mito trips.");
        return allTrips;
    }
}
