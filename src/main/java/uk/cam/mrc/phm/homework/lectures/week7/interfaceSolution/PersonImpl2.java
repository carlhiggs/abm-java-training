package uk.cam.mrc.phm.homework.lectures.week7.interfaceSolution;

public class PersonImpl2 implements PersonI{

    private double age;
    @Override
    public int getAge() {
        return (int)this.age;
    }

    @Override
    public void setAge(int age) {
        this.age = Math.min(age, PersonI.MAX_AGE);
    }
}
