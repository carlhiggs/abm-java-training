package uk.cam.mrc.phm.homework.lectures.week9.generics;

public class ObjectList {

    private Object[] items = new Object[10];
    private int count;

    public void add(Object obj) {
        items[count++] = obj;
    }

    public Object get(int index) {
        return items[index];
    }

}
