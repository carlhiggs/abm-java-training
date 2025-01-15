package uk.cam.mrc.phm.homework.lectures.week5.typicalObject;

import java.util.Random;

public class RandomExercise {
    public static void main(String[] args) {
        Random randomGenerator = new Random(2);
        System.out.println(randomGenerator.nextGaussian());
        System.out.println(randomGenerator.nextGaussian());
        System.out.println(randomGenerator.nextGaussian());
    }
}

