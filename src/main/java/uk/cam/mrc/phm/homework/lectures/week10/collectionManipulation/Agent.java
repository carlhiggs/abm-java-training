package uk.cam.mrc.phm.homework.lectures.week10.collectionManipulation;

public class Agent{

    private int age;
    private double height_m;

    public Agent(int age, double height_m){
        this.age = age;
        this.height_m = height_m;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "age=" + age +
                ", height_m=" + height_m +
                '}';
    }
}
