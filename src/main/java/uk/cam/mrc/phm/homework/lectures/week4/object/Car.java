package uk.cam.mrc.phm.homework.lectures.week4.object;

public class Car {

    double size;
    String color;
    final int MAX_OCCUPANCY = 5;

    void makeNoise() {
        System.out.println("Beep-Beeple");
    }

    void transportPersons() {
        System.out.println("I can transport persons and pets; usual maximum is " + MAX_OCCUPANCY + " persons or pets, please.");
    }

    void transportGoods() {
        System.out.println("I can transport goods and bads as well");
    }

}
