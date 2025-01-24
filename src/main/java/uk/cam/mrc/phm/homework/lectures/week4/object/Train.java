package uk.cam.mrc.phm.homework.lectures.week4.object;

public class Train {

    double size;
    String color;
    final int MAX_OCCUPANCY = 900;

    void makeNoise() {
        System.out.println("Toot-tootle");
    }

    void transportPersons() {
        System.out.println("I can transport no more than " + MAX_OCCUPANCY + " persons. And no pets, sorry.");
    }

    void transportGoods() {
        System.out.println("I can transport a whole lot of goods a long way");
    }

}
