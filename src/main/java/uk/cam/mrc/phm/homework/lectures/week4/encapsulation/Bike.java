package uk.cam.mrc.phm.homework.lectures.week4.encapsulation;

public class Bike {

    private double size;
    private String color;
    private final int MAX_OCCUPANCY = 1;

    public Bike() {
    }
    public Bike(double size) {
        this.size = size;
    }
    public Bike(String color) {
        this.color = color;
    }
    public Bike(double size, String color) {
        this.size = size;
        this.color = color;
    }

    public void makeNoise() {
        System.out.println("Ding-Ding");
    }

    public void transportPersons() {
        System.out.println("I can transport persons and maximum " + MAX_OCCUPANCY + " persons.");
    }

    public void transportGoods() {
        System.out.println("I can transport goods as well");
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
