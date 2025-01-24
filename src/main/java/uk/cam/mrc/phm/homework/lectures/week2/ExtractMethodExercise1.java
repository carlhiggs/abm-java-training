package uk.cam.mrc.phm.homework.lectures.week2;

public class ExtractMethodExercise1 {
    public static void main(String[] args) {
        checkSquare(121);
        checkSquare(81);
        checkSquare(64);
    }

    private static void checkSquare(long val) {
        long sqrt = (long) Math.sqrt(val);
        if (sqrt*sqrt == val ) {
            System.out.println(val + " = " + sqrt + "^2");
        } else {
            System.out.println(val + " is not a square of integer.");
        }
    }
    //Todo add new method here: think on method name, method body, parameters, return type, and access modifier one by one

    //Todo remove related code in the main method

    //Todo update the statement to call the new method in the main
}
