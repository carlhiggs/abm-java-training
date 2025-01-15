package uk.cam.mrc.phm.homework.lectures.week9.generics;

public class CarList {

    private Car[] items = new Car[10];
    private int count;

    public void add(Car car) {
        items[count++] = car;
    }

    public Car get(int index) {
        return items[index];
    }

}
