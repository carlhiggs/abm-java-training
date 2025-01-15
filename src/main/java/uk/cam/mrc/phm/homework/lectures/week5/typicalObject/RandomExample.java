package uk.cam.mrc.phm.homework.lectures.week5.typicalObject;

import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        Random randomGenerator = new Random(1);
        System.out.println(randomGenerator.nextDouble());
        System.out.println(randomGenerator.nextDouble());
        System.out.println(randomGenerator.nextDouble());
    }
}



