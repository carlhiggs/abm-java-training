package uk.cam.mrc.phm.homework.lectures.week10.comparatorExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorAgentRunner {
    public static void main(String[] args) {
        //Create an integer array list
        List<Agent> agents = new ArrayList<>();
        agents.add(new Agent(20, 1.8));
        agents.add(new Agent(12, 1.6));
        agents.add(new Agent(30, 1.7));
        System.out.println(agents);

        //Sort the integer array list by age
        Collections.sort(agents, new AgeAgentComparator());
        System.out.println(agents);

        //Todo: uncomment the following code and create a new Comparator using the height_m in the Agent class
        //Sort the integer array list by height_m
        Collections.sort(agents, new HeightAgentComparator());
        System.out.println(agents);
    }
}
