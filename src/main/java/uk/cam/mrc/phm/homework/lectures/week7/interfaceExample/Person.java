package uk.cam.mrc.phm.homework.lectures.week7.interfaceExample;

public class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person(String name) {
        this(name, 0);
    }
    public Person(int age) {
        this(null, age);
    }
    public Person() {
        this(null, 0);
    }
    public void eat() {
        System.out.println("...... can eat.");
    }
    public void drink() {
        System.out.println("...... can drink.");
    }
    public void introduceSelf() {
        System.out.println("My name is " + this.name + ".");
        System.out.println("I am " + this.age + " years old.");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
