package uk.cam.mrc.phm.homework.lectures.week10.comparableExample;

public class Agent implements Comparable<Agent>{

    private int age;
    private double height_m;

    public Agent(int age, double height_m) {
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

    @Override
    public int compareTo(Agent other) {
        return Integer.compare(this.age, other.age);
    }

}
