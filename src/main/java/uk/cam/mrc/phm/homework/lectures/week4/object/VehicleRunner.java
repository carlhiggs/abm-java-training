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
        bike2.transportPersons();
        bike2.transportGoods();
        bike2.makeNoise();

        Car mitsubishi = new Car();
        mitsubishi.size = 62;
        mitsubishi.color="canary";
        mitsubishi.transportPersons();
        mitsubishi.transportGoods();
        mitsubishi.makeNoise();

        Train upfieldNo19 = new Train();
        upfieldNo19.size = 387;
        upfieldNo19.color = "forest";
        upfieldNo19.transportPersons();
        upfieldNo19.transportGoods();
        upfieldNo19.makeNoise();


    }
}
