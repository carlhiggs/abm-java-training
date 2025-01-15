package uk.cam.mrc.phm.homework.lectures.week7.interfaceSolution;

public class AdultImpl implements AdultI{
    private int age;
    private boolean employmentStatus = false;
    @Override
    public boolean isEmployed() {
        return this.employmentStatus;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void setEmployed() {
        this.employmentStatus = true;
    }
}
