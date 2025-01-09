package uk.cam.mrc.phm.training.day2.fabiland.inputGeneration;

import de.tum.bgu.msm.health.airPollutant.emission.AssignHbefaRoadTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.network.Link;
import org.matsim.api.core.v01.network.Network;
import org.matsim.api.core.v01.network.NetworkWriter;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.scenario.ScenarioUtils;

import java.util.Arrays;
import java.util.List;

public class CreateNetworkHbefaRoadTypes {

    private static final Logger logger = LogManager.getLogger(AssignHbefaRoadTypes.class);
    static String inputFile = "scenarios/fabiland/matsimInput/nw_cap60_2-l_x_lh.xml";
    static String outputFile = "scenarios/fabiland/matsimInput/nw_cap60_2-l_x_lh_hbefa.xml";

    public static void main(String args[]) {
        Config config = ConfigUtils.createConfig();
        config.network().setInputFile(inputFile);
        Scenario scenario = ScenarioUtils.loadScenario(config);
        Network network = scenario.getNetwork();

        for (Link link : network.getLinks().values()) {
            link.getAttributes().putAttribute("hbefa_road_type", "URB/Local/50");
        }

        new NetworkWriter(network).write(outputFile);
    }
}
