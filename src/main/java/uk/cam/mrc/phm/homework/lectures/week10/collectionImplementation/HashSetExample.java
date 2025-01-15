package uk.cam.mrc.phm.homework.lectures.week10.collectionImplementation;

import uk.cam.mrc.phm.homework.lectures.week10.collectionImplementation.agents.AgentI;
import uk.cam.mrc.phm.homework.lectures.week10.collectionImplementation.agents.Dog;
import uk.cam.mrc.phm.homework.lectures.week10.collectionImplementation.agents.Person;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        //Create Agent objects
        Person alex = new Person(1, "Alex");
        Dog bob = new Dog(2, "Bob");
        Person cindy = new Person(3, "Cindy");

        //Create a set for storing Agent objects
        Set<AgentI> agentSet = new HashSet<>();

        //Add Agent objects to agentSet
        System.out.println("Add Agent objects to agents");
        agentSet.add(alex);
        agentSet.add(bob);
        agentSet.add(cindy);
        printAgents(agentSet);

        //Add alex again to agentSet
        agentSet.add(alex);
        printAgents(agentSet);

        // Accessing elements using an enhanced for loop
        for (AgentI agent : agentSet) {
            System.out.println(agent);
        }
        System.out.println();

        // Accessing elements using an iterator
        Iterator<AgentI> iterator = agentSet.iterator();
        while (iterator.hasNext()) {
            AgentI agent = iterator.next();
            System.out.println(agent);
        }
        System.out.println();
    }

    private static void printAgents(Set<AgentI> agentSet) {
        System.out.println("agents has " + agentSet.size() + " objects:");
        for (AgentI agent : agentSet) {
            System.out.println(agent.toString());
        }
        System.out.println();
    }

}
