package uk.cam.mrc.phm.homework.lectures.week9.generics;

public class GenericKeyValuePair<K, V> {

    private K key;
    private V value;

    public GenericKeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "GenericKeyValuePair{" +
                "key=" + key +
                '}';
    }
}
