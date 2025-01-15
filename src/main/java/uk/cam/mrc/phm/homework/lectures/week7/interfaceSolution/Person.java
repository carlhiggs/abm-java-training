package uk.cam.mrc.phm.homework.lectures.week7.interfaceSolution;

public interface Person {
    public final int MAX_AGE = 120;
    public void eat();
    public void drink();
    public void introduceSelf();
    public String getName();
    public void setName(String name);
    public int getAge();
    public void setAge(int age);
}
