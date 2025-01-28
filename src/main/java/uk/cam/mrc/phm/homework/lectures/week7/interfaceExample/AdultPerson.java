package uk.cam.mrc.phm.homework.lectures.week7.interfaceExample;

public class AdultPerson implements Person, Employable {

    private int age;
    private boolean employmentStatus = false;

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public boolean isEmployed() {
        return this.employmentStatus;
    }

    @Override
    public void setEmployed(boolean isEmployed) {
        this.employmentStatus = isEmployed;
    }
}
