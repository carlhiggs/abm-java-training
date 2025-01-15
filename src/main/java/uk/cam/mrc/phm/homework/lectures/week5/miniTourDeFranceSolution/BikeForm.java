package uk.cam.mrc.phm.homework.lectures.week5.miniTourDeFranceSolution;

public enum BikeForm {

    ROADBIKE(2.0),
    TRACKBIKE(1.5),
    MOUNTAINBIKE(1.2);

    private final double acceleration;
    BikeForm(double acceleration){
        this.acceleration = acceleration;
    }
    public double getAcceleration() {
        return acceleration;
    }
}
