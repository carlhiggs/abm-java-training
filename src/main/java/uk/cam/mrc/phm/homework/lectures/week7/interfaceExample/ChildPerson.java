package uk.cam.mrc.phm.homework.lectures.week7.interfaceExample;

public class ChildPerson implements Person {
    private int age;

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getAge() {
        return this.age;
    }
}
