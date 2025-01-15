package uk.cam.mrc.phm.homework.lectures.week7.animal;

public class Cat extends Feline{

    @Override
    public void eat(){
        System.out.println("eat() in Cat class.");
    }

    @Override
    public void makeSound(){
        System.out.println("makeSound() in Cat class.");
    }

}
