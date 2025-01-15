package uk.cam.mrc.phm.homework.lectures.week10.iterableExample;

import java.util.Iterator;

public class GenericList<T> implements Iterable<T>{

    public T[] items = (T[]) new Object[3];
    private int count;

    public void add(T item) {
        items[count++] = item;
    }

    public T get(int index) {
        return items[index];
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }


}
