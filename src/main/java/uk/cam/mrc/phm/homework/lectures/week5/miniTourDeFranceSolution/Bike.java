package uk.cam.mrc.phm.homework.lectures.week5.miniTourDeFranceSolution;

import java.util.Random;

public class Bike {
    private static int bikeCounts;
    private static final int MAX_SPEED = 5;
    private static final int MIN_SPEED = 0;
    private static final Random rmd = new Random(0);
    private final int id;
    private final BikeForm bikeForm;
    private double position;
    private double speed;

    public Bike(int id, BikeForm bikeForm) {
        this.id = id;
        this.bikeForm = bikeForm;
        this.position = 0;
        this.speed = 0;
        bikeCounts += 1;
    }

    private void accelerate() {
        if (this.speed < MAX_SPEED) {
            this.speed += this.bikeForm.getAcceleration();
        }
        if (this.speed > MAX_SPEED) {
            this.speed = MAX_SPEED;
        }
    }

    private void decelerate() {
        if (this.speed > MIN_SPEED) {
            this.speed -= 1;
        }
        if (this.speed < MIN_SPEED) {
            this.speed = MIN_SPEED;
        }
    }

    public void move() {
        this.position += this.speed;

        double probability = rmd.nextDouble();
        if (probability <= 0.4) {
            accelerate();
        } else if (probability <= 0.8) {
            decelerate();
        }

    }

    public int getId() {
        return id;
    }

    public double getPosition() {
        return this.position;
    }

    public static int getBikeCounts() {
        return bikeCounts;
    }
}
