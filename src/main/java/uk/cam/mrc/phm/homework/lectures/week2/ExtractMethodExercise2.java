package uk.cam.mrc.phm.homework.lectures.week2;

public class ExtractMethodExercise2 {
    public static void main(String[] args) {
        //Todo IntelliJ has many user-friendly function to deal with code including extracting method

        long val = 122;

        //Todo using mouse to select the chuck of the code that need to be in a method
        //Todo right click on your mouse and select Refactor/Extract Method and then input a descriptive method name
        //Todo rename class name and method name can be done by Refactor/Rename
        for (int i = 1; ; i++) {

            if (i * i == val) {
                System.out.println(val + " = " + i + "^2");
                break;
            }

            if (i * i > val) {
                System.out.println(val + " is not a square of integers.");
                break;
            }
        }
    }
}
