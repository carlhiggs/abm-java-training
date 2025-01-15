package uk.cam.mrc.phm.homework.lectures.week12.exceptions;

public class Oven {


    private final double FAILED_PROBABILITY = 0.5;

    public void turnOn(){

        System.out.println("The oven is turned on.");

    }

    public void bake() throws BurnedException{
        if (Math.random() <= FAILED_PROBABILITY){
            System.out.println("The cake is successfully baked!");
        }else {
            System.out.println("The cake is burned!");
            throw new BurnedException();
        }
    }


    public void turnOff(){
        System.out.println("The oven is turned off.");
    }

}
