package uk.cam.mrc.phm.homework.lectures.week4.encapsulation;

public class Car {

    private double size;
    private String color;
    private final int MAX_OCCUPANCY = 1;

    public Car() {
    }
    public Car(double size) {
        this.size = size;
    }
    public Car(String color) {
        this.color = color;
    }
    public Car(double size, String color) {
        this.size = size;
        this.color = color;
    }

    public void makeNoise() {
        System.out.println("Beep-Beeple");
    }

    public void transportPersons() {
        System.out.println("I can transport persons and pets; usual maximum is " + MAX_OCCUPANCY + " persons or pets, please.");
    }

    public void transportGoods() {
        System.out.println("I can transport goods and bads as well");
    }

    public double getSize() {
        return size;
    }
    public void setSize(double size) {
        this.size = size;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getMAX_OCCUPANCY() {
        return MAX_OCCUPANCY;
    }
}
