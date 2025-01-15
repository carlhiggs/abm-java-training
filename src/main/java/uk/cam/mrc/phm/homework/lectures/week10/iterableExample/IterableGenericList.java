package uk.cam.mrc.phm.homework.lectures.week10.iterableExample;

import java.util.Iterator;

public class IterableGenericList<T> implements Iterable<T> {

    T[] items = (T[]) new Object[3];
    int count;

    public void add(T item) {
        items[count++] = item;
    }

    public T get(int index) {
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }

    private class ListIterator implements Iterator<T> {
        private IterableGenericList<T> list;
        private int index;

        public ListIterator(IterableGenericList<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return (index < list.count);
        }

        @Override
        public T next() {
            return list.items[index++];
        }
    }
}
