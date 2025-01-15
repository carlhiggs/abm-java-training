package uk.cam.mrc.phm.homework.lectures.week10.collectionImplementation;


import uk.cam.mrc.phm.homework.lectures.week10.collectionImplementation.agents.AgentI;
import uk.cam.mrc.phm.homework.lectures.week10.collectionImplementation.agents.Dog;
import uk.cam.mrc.phm.homework.lectures.week10.collectionImplementation.agents.Person;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExercise {
    public static void main(String[] args) {

        //Create Agent objects
        System.out.println("Create Agent objects");
        Person alex = new Person(1, "Alex");
        Dog bob = new Dog(2, "Bob");
        Person cindy = new Person(3, "Cindy");

        //Create an ArrayList to store Agent objects
        System.out.println("Create an ArrayList to store Agent objects");
        List<AgentI> agents = new ArrayList<>();

        //Todo: write a sentence to describe the add() in the System.out.println("...");
        System.out.println("...");
        agents.add(alex);
        agents.add(bob);
        printAgents(agents);

        //Todo: write a sentence to describe the isEmpty() in the System.out.println("...");
        System.out.println("...");
        if (agents.isEmpty()) {
            System.out.println("..."); // Todo add a meaningful message in the System.out.println("...");
            System.out.println();
        } else {
            System.out.println("..."); // Todo add a meaningful message in the System.out.println("...");
            System.out.println();
        }

        //Todo: write a sentence to describe the size() in the System.out.println("...");
        System.out.println("...");
        System.out.println(agents.size());
        System.out.println();

        //Todo: write a sentence to describe the add(x, y) in the System.out.println("...");
        System.out.println("...");
        agents.add(2, cindy);
        printAgents(agents);

        //Todo: write a sentence to describe the contains() in the System.out.println("...");
        System.out.println("...");
        if (agents.contains(alex)) {
            System.out.println("..."); // Todo add a meaningful message in the System.out.println("...");
            System.out.println();
        } else {
            System.out.println("..."); // Todo add a meaningful message in the System.out.println("...");
            System.out.println();
        }

        //Todo: write a sentence to describe the get() in the System.out.println("...");
        System.out.println("...");
        AgentI agent1 = agents.get(0);
        System.out.println(agent1);
        System.out.println();

        //Todo: write a sentence to describe the set(x, y) in the System.out.println("...");
        System.out.println("...");
        agents.set(0, cindy);
        printAgents(agents);

        //Todo: write a sentence to describe the remove() in the System.out.println("...");
        System.out.println("...");
        agents.remove(cindy);
        agents.remove(bob);
        printAgents(agents);

        //Todo: write a sentence to describe the clear() in the System.out.println("...");
        System.out.println("...");
        agents.clear();
        printAgents(agents);
    }

    private static void printAgents(List<AgentI> agents) {
        System.out.println("agents has " + agents.size() + " objects:");
        for (AgentI agent : agents) {
            System.out.println(agent.toString());
        }
        System.out.println("=========================");
    }
}
