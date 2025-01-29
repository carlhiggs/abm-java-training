package uk.cam.mrc.phm.homework.lectures.week11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExercise {
    public static void main(String[] args) {


        //Pay attention to the null pointer exception when using get().
        Map<Integer, List<String>> personMap = new HashMap<>();

        List<String> result = personMap.get(1);
        if (result == null) {
            result = new java.util.ArrayList<>();
            personMap.put(1, new ArrayList<>());
        }
        personMap.get(1).add(new String("Alice"));


    }
}
