package uk.cam.mrc.phm.homework.lectures.week7.animal;

public class Wolf extends Canine{

    @Override
    public void eat(){
        System.out.println("eat() in Wolf class.");
    }

    @Override
    public void makeSound(){
        System.out.println("makeSound() in Wolf class.");
    }

}
