package uk.cam.mrc.phm.homework.lectures.week10.collectionManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample {
    public static void main(String[] args) {
        //Create an integer array list
        List<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(3);
        integerArrayList.add(2);
        integerArrayList.add(1);
        System.out.println(integerArrayList);

        //Shuffle the integer array list
        Collections.shuffle(integerArrayList);
        System.out.println(integerArrayList);

        //Sort the integer array list
        Collections.sort(integerArrayList);
        System.out.println(integerArrayList);

        //Create an agent array list
        List<Agent> agents = new ArrayList<>();
        agents.add(new Agent(20, 1.8));
        agents.add(new Agent(12, 1.6));
        agents.add(new Agent(30, 1.7));
        System.out.println(agents);

/*        //Shuffle the agent array list
        Collections.shuffle(agents);
        System.out.println(agents);

        //Sort the agent array list
        Collections.sort(agents);
        System.out.println(agents);*/

    }
}
