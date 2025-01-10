package uk.cam.mrc.phm.training.day2.fabiland.models;

import de.tum.bgu.msm.data.ZoneMCR;
import de.tum.bgu.msm.data.person.Gender;
import de.tum.bgu.msm.data.person.Person;
import de.tum.bgu.msm.health.HealthDataContainerImpl;
import de.tum.bgu.msm.health.data.DataContainerHealth;
import de.tum.bgu.msm.health.data.PersonHealth;
import de.tum.bgu.msm.health.disease.Diseases;
import de.tum.bgu.msm.health.disease.HealthExposures;
import de.tum.bgu.msm.models.demography.death.DeathStrategy;
import uk.cam.mrc.phm.training.day2.fabiland.data.FabilandHealthDataContainer;

public class DeathStrategyFabiland implements DeathStrategy {

    private final DataContainerHealth dataContainer;
    private final Boolean adjustByRelativeRisk;

    public DeathStrategyFabiland(FabilandHealthDataContainer dataContainer, Boolean adjustByRelativeRisk) {
        this.dataContainer = dataContainer;
        this.adjustByRelativeRisk = adjustByRelativeRisk;
    }

    @Override
    public double calculateDeathProbability(Person person) {
        final int personAge = Math.min(person.getAge(), 100);
        Gender personSex = person.getGender();

        if (personAge < 0){
            throw new RuntimeException("Undefined negative person age!"+personAge);
        }

        //cap age at 100, over 100 all cause mortality prob = 1
        if (personAge >= 100){
            return 1.;
        }


        //all zones have same transition data
        String location = "1";
        String compositeKey = dataContainer.createTransitionLookupIndex(Math.min(person.getAge(), 100), personSex, location);

        double alpha = dataContainer.getHealthTransitionData().get(Diseases.all_cause_mortality).get(compositeKey);

        //no rr adjustment for age under 18
        if(personAge < 18){
            return alpha;
        }

        if(adjustByRelativeRisk){
            for(HealthExposures healthExposures : ((PersonHealth)person).getRelativeRisksByDisease().keySet()){
                alpha *=  ((PersonHealth)person).getRelativeRisksByDisease().get(healthExposures).get(Diseases.all_cause_mortality);
            }
        }

        return alpha;
    }
}