package uk.cam.mrc.phm.homework.lectures.week4.object;

public class Bike {

    double size;
    String color;
    final int MAX_OCCUPANCY = 1;

    void makeNoise() {
        System.out.println("Ding-Ding");
    }

    void transportPersons() {
        System.out.println("I can transport persons and maximum " + MAX_OCCUPANCY + " persons.");
    }

    void transportGoods() {
        System.out.println("I can transport goods as well");
    }

}
