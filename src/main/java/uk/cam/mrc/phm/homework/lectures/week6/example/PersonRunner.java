package uk.cam.mrc.phm.homework.lectures.week6.example;

public class PersonRunner {

    public static void main(String[] args) {

        Adult tom = new Adult();
        tom.setName("Tom");
        tom.setAge(32);

        System.out.println("My name is " + tom.getName() + " and I am " + tom.getAge() + " years old.");
        tom.eat();
        tom.drink();
        tom.drive();

        Child jerry = new Child();
        jerry.setName("Jerry");
        jerry.setAge(12);

        System.out.println("My name is " + jerry.getName() + " and I am " + jerry.getAge() + " years old.");
        jerry.eat();
        jerry.drink();

        Person bob = new Child("bob", 12);
        Person sandy = new Adult("sandy", 20, false);

        bob.drink();
        sandy.drink();

        Person[] personArray = new Person[2];
        personArray[0] = bob;
        personArray[1] = sandy;

        Adult adultSandy = (Adult) sandy;
        adultSandy.drive();

        ((Adult)sandy).drive();

    }

}
