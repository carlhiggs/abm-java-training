package uk.cam.mrc.phm.homework.lectures.week4.object;

public class VehicleRunner {
    public static void main(String[] args) {

        Bike bike1 = new Bike();
        bike1.size = 26;
        bike1.color = "silver";
        System.out.println("This is a " + bike1.size + " zoll bike.");
        System.out.println("The bike's color is " + bike1.color + ".");
        bike1.makeNoise();

        Bike bike2 = new Bike();
        bike2.makeNoise();



    }
}
