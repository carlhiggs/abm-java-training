package uk.cam.mrc.phm.homework.lectures.week9.generics;

public class IntegerList {

    private int[] items = new int[10];
    private int count;

    public void add(int item) {
        items[count++] = item;
    }

    public int get(int index) {
        return items[index];
    }

}
