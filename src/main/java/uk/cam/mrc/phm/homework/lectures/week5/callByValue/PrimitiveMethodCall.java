package uk.cam.mrc.phm.homework.lectures.week5.callByValue;

public class PrimitiveMethodCall {

    public static void main(String[] args) {
        int x = 1;
        addOne(x);
        addTwo(x);
        System.out.println(x);
    }

    private static void addOne(int value) {
        int x = value + 1;
    }

    private static void addTwo(int value) {
        int x = value + 2;
    }

}
