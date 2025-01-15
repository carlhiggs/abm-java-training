package uk.cam.mrc.phm.homework.lectures.week10.comparatorExample;

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



    public int getAge() {
        return age;
    }

    public double getHeight_m() {
        return height_m;
    }
}
