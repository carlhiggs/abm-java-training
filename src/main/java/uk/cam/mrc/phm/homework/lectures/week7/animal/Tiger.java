package uk.cam.mrc.phm.homework.lectures.week7.animal;

public class Tiger extends Feline{

    @Override
    public void eat(){
        System.out.println("eat() in Tiger class.");
    }

    @Override
    public void makeSound(){
        System.out.println("makeSound() in Tiger class.");
    }

}
