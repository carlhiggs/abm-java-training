package uk.cam.mrc.phm.homework.lectures.week7.animal;

public class Dog extends Canine{

    @Override
    public void eat(){
        System.out.println("eat() in Dog class.");
    }

    @Override
    public void makeSound(){
        System.out.println("makeSound() in Dog class.");
    }

}
