package uk.cam.mrc.phm.homework.lectures.week11;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExamples {

    public static void main(String[] args) {
        //create a map
        Map<String,Integer> personAgeMap =  new HashMap<>();
        personAgeMap.put("Charly", 40);
        personAgeMap.put("Alice", 30);
        personAgeMap.put("Bob", 31);
        System.out.println(personAgeMap);

        //You can create a new Map that copies elements from an existing map
        Map<String, Integer> personAgeLinkedHashMap = new LinkedHashMap<>(personAgeMap);
        System.out.println(personAgeLinkedHashMap);

        Map<String, Integer> personAgeTreeMap = new TreeMap<>(personAgeMap);
        System.out.println(personAgeTreeMap);

        Map<String, Integer> personAgeLinkedHashMap2 = new LinkedHashMap<>(personAgeTreeMap);
        System.out.println(personAgeLinkedHashMap2);

        //hashMap and linkedHashMap allow nulls, but treeMap does not allow nulls.
        personAgeMap.put(null,99);
        personAgeMap.put("a",null);
        System.out.println(personAgeMap);

        //personAgeTreeMap.put(null,99);
        //System.out.println(personAgeTreeMap);





        //3 different ways for iteration
        //print out name list of the person map.
        for (String name : personAgeMap.keySet()){
            System.out.println(name);
        }

        //print out ages of the person map
        for(Integer age : personAgeLinkedHashMap.values()){
            System.out.println("age: " + age);

        }

        //print out name and age pair
        for(Map.Entry<String, Integer> entry : personAgeTreeMap.entrySet()){
            System.out.println("name: " + entry.getKey() + "|age: " + entry.getValue());
        }
    }
}
