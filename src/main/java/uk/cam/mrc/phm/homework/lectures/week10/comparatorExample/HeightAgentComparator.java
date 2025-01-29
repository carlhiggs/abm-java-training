package uk.cam.mrc.phm.homework.lectures.week10.comparatorExample;

import java.util.Comparator;

public class HeightAgentComparator implements Comparator<Agent> {
    @Override
    public int compare(Agent agent1, Agent agent2) {
        return Double.compare(
            agent1.getHeight_m(),
            agent2.getHeight_m()
        );
    }
}
