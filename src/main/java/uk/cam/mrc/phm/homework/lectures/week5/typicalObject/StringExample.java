package uk.cam.mrc.phm.homework.lectures.week5.typicalObject;

public class StringExample {
    public static void main(String[] args) {
        String string1 = "Hello";
        String string2 = "Hello";
        String string3 = string1;
        String string4 = new String("Hello");

        //Example: == vs. .equals()
        System.out.println(string1 == string2);
        System.out.println(string3 == string4);
        System.out.println(string1.equals(string2));
        System.out.println(string3.equals(string4));

        //Example: .toUpperCase()
        String string = "Hello";
        System.out.println(string.toUpperCase());
        System.out.println(string);

        string += string.toUpperCase();
        System.out.println(string);

    }
}
