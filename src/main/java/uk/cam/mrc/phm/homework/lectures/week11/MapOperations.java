package uk.cam.mrc.phm.homework.lectures.week11;

import java.util.HashMap;
import java.util.Map;

public class MapOperations {

    public static void main(String[] args) {
        //create a map
        Map<String,Integer> personAgeMap =  new HashMap<>();
        personAgeMap.put("Charly", 40);
        personAgeMap.put("Alice", 30);
        personAgeMap.put("Bob", 31);
        System.out.println(personAgeMap);

        //Basic operations of Map
        //put element
        personAgeMap.put("Alice",99);
        System.out.println(personAgeMap);

        //containKey/value
        Boolean check = personAgeMap.containsKey("Diana");
        System.out.println(check);

        //remove
        personAgeMap.remove("Alice");
        System.out.println(personAgeMap);

        //replace
        System.out.println(personAgeMap);
        Integer oldValue = personAgeMap.get("Bob");
        personAgeMap.replace("Bob",30);
        System.out.println("Old value: " + oldValue);
        System.out.println(personAgeMap);

        //size and isEmpty
        System.out.println(personAgeMap.size());
        personAgeMap = new HashMap<>();
        System.out.println(personAgeMap.isEmpty());



    }
}
