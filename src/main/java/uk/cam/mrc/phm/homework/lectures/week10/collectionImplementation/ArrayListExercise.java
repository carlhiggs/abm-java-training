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
        System.out.println("Adding agents to the list");
        agents.add(alex);
        agents.add(bob);
        printAgents(agents);

        //Todo: write a sentence to describe the isEmpty() in the System.out.println("...");
        System.out.println("Checking if the agents list has any members...");
        if (agents.isEmpty()) {
            System.out.println("... There are no members of the agents list."); // Todo add a meaningful message in the System.out.println("...");
            System.out.println();
        } else {
            System.out.println("The members of the agents list are "+agents.toString()); // Todo add a meaningful message in the System.out.println("...");
            System.out.println();
        }

        //Todo: write a sentence to describe the size() in the System.out.println("...");
        System.out.println("The number of members in the agents list is: ");
        System.out.println(agents.size());
        System.out.println();

        //Todo: write a sentence to describe the add(x, y) in the System.out.println("...");
        System.out.println("Adding an additional agent to the list at specified index position (2)");
        agents.add(2, cindy);
        printAgents(agents);

        //Todo: write a sentence to describe the contains() in the System.out.println("...");
        System.out.println("Checking if the agents list contains the person Alex...");
        if (agents.contains(alex)) {
            System.out.println("The person Alex is a member of the agents list"); // Todo add a meaningful message in the System.out.println("...");
            System.out.println();
        } else {
            System.out.println("The person Alex is not a member of the agents list"); // Todo add a meaningful message in the System.out.println("...");
            System.out.println();
        }

        //Todo: write a sentence to describe the get() in the System.out.println("...");
        System.out.println("Retrieving the first agent in the list:");
        AgentI agent1 = agents.get(0);
        System.out.println(agent1);
        System.out.println();

        //Todo: write a sentence to describe the set(x, y) in the System.out.println("...");
        System.out.println("Modifying the first agent in the list to also be the person Cindy");
        agents.set(0, cindy);
        printAgents(agents);

        //Todo: write a sentence to describe the remove() in the System.out.println("...");
        System.out.println("Removing the first instance of agents called Bob and Cindy from the list; note that subsequent instances may remain.");
        agents.remove(cindy);
        agents.remove(bob);
        printAgents(agents);

        //Todo: write a sentence to describe the clear() in the System.out.println("...");
        System.out.println("Clearing the agents list and verifying that the agent list is empty");
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
