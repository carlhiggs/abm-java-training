package uk.cam.mrc.phm.homework.lectures.week6.example;

public class Child extends Person {
    public Child(String name, int age) {
        super(name, age);
    }
    public Child(String name) {
        super(name, 0);
    }
    public Child(int age) {
        super(null, age);
    }
    public Child() {
        super(null, 0);
    }
    @Override
    public void drink() {
        super.drink();
        System.out.println(super.getName()+" cannot drink alcohol.");
    }
}
