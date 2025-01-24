package uk.cam.mrc.phm.homework.lectures.week2;

public class SquareRootExercise {

    public static void main(String[] args) {
        // Check if no arguments have been supplied
        if (args.length == 0) {
            args = new String[]{"9"};
        }

        // Instantiate val as a long variable using first argument
        long val = Long.parseLong(args[0]);

        // Check if val is the square of an integer number
        long sqrt = (long) Math.sqrt(val);
        if (sqrt*sqrt == val ) {
            //Todo if val is the square of an integer number, print the following statement; for example, 81 = 9^2,in the console.
            System.out.println(val + " = " + sqrt + "^2");
        } else {
            //Todo if val doesn’t have an integer square root, please print; for example, 79 is not a square of integer.
            System.out.println(val + " is not a square of integer.");
        }
        //Make good use of break or continue to reduce the run time of your program.
    }

}
