package uk.cam.mrc.phm.homework.lectures.week10.iterableExample;


import uk.cam.mrc.phm.homework.lectures.week10.collectionImplementation.agents.AgentI;
import uk.cam.mrc.phm.homework.lectures.week10.collectionImplementation.agents.Dog;
import uk.cam.mrc.phm.homework.lectures.week10.collectionImplementation.agents.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListComparison {

    public static void main(String[] args) {

        //Create Agent objects
        Person alex = new Person(1, "Alex");
        Dog bob = new Dog(2, "Bob");
        Person cindy = new Person(3, "Cindy");
        Person david = new Person(4, "David");

        //Create an ArrayList for storing Agent objects
        List<AgentI> agents = new ArrayList<>();
        agents.add(alex);
        agents.add(bob);
        agents.add(cindy);

        //for-each loop
//        for (AgentI agent:agents){
//            if (agent.getId()==3)
//                agents.remove(2);
//        }

        //Iterator
        for (Iterator<AgentI> it = agents.iterator(); it.hasNext(); ){
            AgentI agent = it.next();
            if (agent.getId() == 3)
                it.remove();
        }

    }
}
