package uk.cam.mrc.phm.homework.lectures.week5.callByValue;

public class Trip {

    private int travelDistanceKm;

    private int travelTimeMin;


    public Trip(int travelDistanceKm, int travelTimeMin) {
        this.travelDistanceKm = travelDistanceKm;
        this.travelTimeMin = travelTimeMin;
    }

    public void setTravelTimeMin(int travelTimeMin) {
        this.travelTimeMin = travelTimeMin;
    }

    public int getTravelTimeMin() {
        return travelTimeMin;
    }
}
