package uk.cam.mrc.phm.homework.lectures.week4.encapsulation;

public class Train {

    private double size;
    private String color;
    private final int MAX_OCCUPANCY = 1;

    public Train() {
    }
    public Train(double size) {
        this.size = size;
    }
    public Train(String color) {
        this.color = color;
    }
    public Train(double size, String color) {
        this.size = size;
        this.color = color;
    }

    void makeNoise() {
        System.out.println("Toot-tootle");
    }

    void transportPersons() {
        System.out.println("I can transport no more than " + MAX_OCCUPANCY + " persons. And no pets, sorry.");
    }

    void transportGoods() {
        System.out.println("I can transport a whole lot of goods a long way");
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
