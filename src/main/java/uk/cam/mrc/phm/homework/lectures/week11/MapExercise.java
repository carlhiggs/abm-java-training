package uk.cam.mrc.phm.homework.lectures.week11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExercise {
    public static void main(String[] args) {


        //Pay attention to the null pointer exception when using get().
        Map<Integer, List<String>> personMap = new HashMap<>();

        personMap.get(1).add(new String("Alice"));


    }
}
