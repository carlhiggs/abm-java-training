package uk.cam.mrc.phm.homework.lectures.week12.io.tripReportTaskSolution;

public class Trip {
    private int id;
    private double originX;
    private double originY;
    private double destinationX;
    private double destinationY;
    private double departureTime;
    private double travelTime;
    private double travelTimeInMin;
    private String departureTimeHHMM;
    private double speed;
    private double distance;

    public Trip(int id){
        this.id = id;
    }

    public double getOriginX() {
        return originX;
    }

    public void setOriginX(double originX) {
        this.originX = originX;
    }

    public double getOriginY() {
        return originY;
    }

    public void setOriginY(double originY) {
        this.originY = originY;
    }

    public double getDestinationX() {
        return destinationX;
    }

    public void setDestinationX(double destinationX) {
        this.destinationX = destinationX;
    }

    public double getDestinationY() {
        return destinationY;
    }

    public void setDestinationY(double destinationY) {
        this.destinationY = destinationY;
    }

    public double getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(double departureTime) {
        this.departureTime = departureTime;
    }

    public double getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(double travelTime) {
        this.travelTime = travelTime;
    }

    public double getTravelTimeInMin() {
        return travelTimeInMin;
    }

    public void setTravelTimeInMin(double travelTimeInMin) {
        this.travelTimeInMin = travelTimeInMin;
    }

    public String getDepartureTimeHHMM() {
        return departureTimeHHMM;
    }

    public void setDepartureTimeHHMM(String departureTimeHHMM) {
        this.departureTimeHHMM = departureTimeHHMM;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getId() {
        return id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
