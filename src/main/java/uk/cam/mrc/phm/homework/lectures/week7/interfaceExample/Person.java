package uk.cam.mrc.phm.homework.lectures.week7.interfaceExample;

//public interface Person {
//    static int max_age = 120;
//
//    void eat();
//    void drink();
//    void introduceSelf();
//    String getName();
//    void setName(String name);
//    int getAge();
//    void setAge(int age);
//}


public interface Person {
    public final static int MAX_AGE = 120;

    public void setAge(int age);
    public int getAge();
}
