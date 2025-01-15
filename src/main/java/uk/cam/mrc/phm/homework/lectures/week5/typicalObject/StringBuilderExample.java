package uk.cam.mrc.phm.homework.lectures.week5.typicalObject;

public class StringBuilderExample {
    public static void main(String[] args) {

        StringBuilder string = new StringBuilder("Hello");

        string.append(" World!");
        System.out.println(string);

        string.replace(6,11, "Aliens!");
        System.out.println(string);

        string.insert(6, 35);
        System.out.println(string);

    }
}

