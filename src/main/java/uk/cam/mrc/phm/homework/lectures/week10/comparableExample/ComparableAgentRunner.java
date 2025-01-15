package uk.cam.mrc.phm.homework.lectures.week10.comparableExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableAgentRunner {
    public static void main(String[] args) {
        //Create an agent array list
        List<Agent> agents = new ArrayList<>();
        agents.add(new Agent(20, 1.8));
        agents.add(new Agent(12, 1.6));
        agents.add(new Agent(30, 1.7));
        System.out.println(agents);

        //Sort the agent array list
        Collections.sort(agents);
        System.out.println(agents);
    }
}
