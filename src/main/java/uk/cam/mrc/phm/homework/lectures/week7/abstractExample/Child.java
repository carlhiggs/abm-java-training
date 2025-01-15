package uk.cam.mrc.phm.homework.lectures.week7.abstractExample;

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
    public void introduceSelf() {
        super.introduceSelf();
        System.out.println("I can only drink Punsch.");
    }
}
