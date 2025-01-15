package uk.cam.mrc.phm.homework.lectures.week9.generics;

public class GenericKeyValuePairRunner {
    public static void main(String[] args) {
        GenericKeyValuePair<String, Integer> anton = new GenericKeyValuePair<>("Anton", 32);
        GenericKeyValuePair<String, Integer> bob = new GenericKeyValuePair<>("bob", 23);
        GenericList<GenericKeyValuePair<String, Integer>> persons = new GenericList<>();
        persons.add(anton);
        persons.add(bob);
        System.out.println(persons.get(0));
    }
}
