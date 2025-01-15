package uk.cam.mrc.phm.homework.lectures.week7.interfaceSolution;

public class PersonImpl1 implements PersonI{
    private int age;
    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }
}
