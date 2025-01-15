package uk.cam.mrc.phm.homework.lectures.week2;

public class SquareRootSolution {
    public static void main(String[] args) {
        long val = 121;

        //search for square root of val
        for (int i = 1; ; i++) {

            //break out loop if i^2 == val
            if (i * i == val) {
                System.out.println(val + " = " + i + "^2");
                break;
            }

            //break out of loop if squared i is already greater than val
            if (i * i > val) {
                System.out.println(val + " is not a square of integers.");
                break;
            }
        }
    }
}
