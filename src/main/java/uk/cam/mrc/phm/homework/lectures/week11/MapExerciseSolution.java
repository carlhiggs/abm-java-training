package uk.cam.mrc.phm.homework.lectures.week11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExerciseSolution {
    public static void main(String[] args) {
        //Pay attention to the null pointer exception when using get().
        Map<Integer, List<String>> personMap = new HashMap<>();

        //personMap.get(1).add(new String("a"));

        //Solution 1 use if/else statements
        List<String> personList1;

        if(personMap.containsKey(1)){
            personList1 = personMap.get(1);//If list exists in map, get list from map
        }else{
            //List does not exist yet, create new list and map to key 1
            personList1 = new ArrayList<>();
            personMap.put(1, personList1);
        }
        personList1.add("Alice"); //Add new person to list
        System.out.println(personMap);

        //Solution 2, check for null first
        List<String> personList2 = personMap.get(2);

        if(personList2 == null){
           personList2 = new ArrayList<>();
           personMap.put(2, personList2);
        }
        personMap.get(2).add("Bob"); //Add new person to list
        System.out.println(personMap);

    }
}
