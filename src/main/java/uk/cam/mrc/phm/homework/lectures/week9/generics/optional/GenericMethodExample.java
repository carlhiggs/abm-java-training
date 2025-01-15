package uk.cam.mrc.phm.homework.lectures.week9.generics.optional;

public class GenericMethodExample {

    public static void printInput(String input) {
        System.out.println(input);
    }

    public static <T> void printInputGeneric(T input) {
        System.out.println(input);
    }

    public static void printKeyValuePair(String key, int value) {
        System.out.println(key + "-" + value);
    }

    public static <K, V> void printKeyValuePairGeneric(K key, V value) {
        System.out.println(key + "-" + value);
    }

}
