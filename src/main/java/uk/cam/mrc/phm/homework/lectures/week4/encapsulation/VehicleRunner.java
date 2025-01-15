package uk.cam.mrc.phm.homework.lectures.week4.encapsulation;

public class VehicleRunner {

    public static void main(String[] args) {

        Bike bike3 = new Bike();
        bike3.setSize(26);
        System.out.println("Bike 3 is " + bike3.getSize() + " zoll.");

        Bike bike4 = new Bike("red");
        Bike bike5 = new Bike(29);
        Bike bike6 = new Bike(27, "blue");

    }
}
