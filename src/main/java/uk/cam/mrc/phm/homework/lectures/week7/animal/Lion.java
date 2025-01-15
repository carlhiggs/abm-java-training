package uk.cam.mrc.phm.homework.lectures.week7.animal;

public class Lion extends Feline{

    @Override
    public void eat(){
        System.out.println("eat() in Lion class.");
    }

    @Override
    public void makeSound(){
        System.out.println("makeSound() in Lion class.");
    }

}
