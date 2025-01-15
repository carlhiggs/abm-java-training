package uk.cam.mrc.phm.homework.lectures.week10.collectionImplementation;



import uk.cam.mrc.phm.homework.lectures.week10.collectionImplementation.agents.AgentI;
import uk.cam.mrc.phm.homework.lectures.week10.collectionImplementation.agents.Dog;
import uk.cam.mrc.phm.homework.lectures.week10.collectionImplementation.agents.Person;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {

        //Create Agent objects
        Person alex = new Person(1, "Alex");
        Dog bob = new Dog(2, "Bob");
        Person cindy = new Person(3, "Cindy");

        //Create an LinkedList for storing Agent objects
        LinkedList<AgentI> agents = new LinkedList<>();

        //Add Agent objects to agents
        System.out.println("Add Agent objects to agents");
        agents.add(alex);
        agents.add(bob);
        printAgents(agents);

        //Check whether agents is empty
        System.out.println("Check whether agents is empty");
        if (agents.isEmpty()) {
            System.out.println("List agents is empty");
            System.out.println();
        } else {
            System.out.println("List agents is not empty");
            System.out.println();
        }

        //Check agents size
        System.out.println("Check agents size");
        System.out.println(agents.size());
        System.out.println();

        //Add object to a specific position
        System.out.println("Add object to a specific position");
        agents.add(2, cindy);
        printAgents(agents);

        //Check whether agents contains a specific Agent object
        System.out.println("Check whether agents contains a specific Agent object");
        if (agents.contains(alex)) {
            System.out.println("List agents contains the object alex");
            System.out.println();
        } else {
            System.out.println("List agents does not contain the object alex");
            System.out.println();
        }

        //Get a specific Agent object by index
        System.out.println("Get a specific Agent object by index");
        AgentI agent1 = agents.get(0);
        System.out.println(agent1);
        System.out.println();

        //Set a new index for an object
        System.out.println("Set a new index for an object");
        agents.set(0, cindy);
        printAgents(agents);

        //Remove Agent object in agents
        System.out.println("Remove Agent object in agents");
        agents.remove(cindy);
        agents.remove(bob);
        printAgents(agents);

        //Clear agents
        System.out.println("Clear agents");
        agents.clear();
        printAgents(agents);


        System.out.println("Type casting to use linkedlist specific methods");
        LinkedList<AgentI> linkedListAgents = (LinkedList<AgentI>) agents;
        linkedListAgents.addFirst(bob);
        linkedListAgents.addLast(bob);
    }

    private static void printAgents(List<AgentI> agents) {
        System.out.println("agents has " + agents.size() + " objects:");
        for (AgentI agent : agents) {
            System.out.println(agent.toString());
        }
        System.out.println();
    }
}
