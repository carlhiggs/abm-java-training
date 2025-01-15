package uk.cam.mrc.phm.homework.lectures.week12.exceptions;

public class Bakerei {

    public static void main(String[] args) {
        Oven oven = new Oven();

        try{
            oven.turnOn();
            oven.bake();
        }catch(BurnedException e){
            e.printStackTrace();
        }finally {
            oven.turnOff();
        }

    }
}
