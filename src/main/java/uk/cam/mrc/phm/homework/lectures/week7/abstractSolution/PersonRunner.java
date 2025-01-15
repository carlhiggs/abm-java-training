package uk.cam.mrc.phm.homework.lectures.week7.abstractSolution;

public class PersonRunner {
    public static void main(String[] args) {

        Person tom = new Adult("Tom", 32, false);
        tom.introduceSelf();
        tom.drink();
        ((Adult) tom).drive();

        Person jerry = new Child();
        jerry.introduceSelf();
        jerry.drink();


    }
}
