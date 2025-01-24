package uk.cam.mrc.phm.homework.lectures.week1.carl;

public class HelloWorld {
    public static void main(String[] args) {
        String input = (args.length > 0) ? args[0] : "World";
        String message = String.format("Hello, %s.",input);
        System.out.println(message);
    }
}