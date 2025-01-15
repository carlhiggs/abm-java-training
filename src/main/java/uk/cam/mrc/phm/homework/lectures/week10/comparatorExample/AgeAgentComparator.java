package uk.cam.mrc.phm.homework.lectures.week10.comparatorExample;

import java.util.Comparator;

public class AgeAgentComparator implements Comparator<Agent> {
    @Override
    public int compare(Agent agent1, Agent agent2) {
        if (agent1.getAge() < agent2.getAge()){
            return -1;
        }else if(agent1.getAge() == agent2.getAge()){
            return 0;
        }else{
            return 1;
        }

    }
}
