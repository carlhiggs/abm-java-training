package uk.cam.mrc.phm.training.day2.manchester.run;

import org.matsim.api.core.v01.Scenario;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;
import org.matsim.core.scenario.ScenarioUtils;

public class RunMatsimManchester {

    // Scale factor (must be same as specified when generating demand)
    private static final double SCALE_FACTOR = 0.01;

    public static void main(String[] args) {
        Config config = ConfigUtils.loadConfig("scenarios/manchester/config.xml");

        // Specify input network and plans files
        config.network().setInputFile("network/greater-manchester.xml");
        config.plans().setInputFile("demand/plans.xml");

        // Specify scale factor
        config.qsim().setFlowCapFactor(SCALE_FACTOR);
        config.qsim().setStorageCapFactor(SCALE_FACTOR);

        Scenario scenario = ScenarioUtils.loadScenario(config) ;

        Controler controler = new Controler( scenario ) ;
        controler.run();

    }

}
