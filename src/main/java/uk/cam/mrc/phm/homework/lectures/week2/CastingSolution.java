package uk.cam.mrc.phm.homework.lectures.week2;

public class CastingSolution {

    public static void main(String[] args) {

        double result1 = 10/3; //The operation 10/3 was operated under the integer type (3) and then cast to double type (3.0)
        double result2 = (double) 10 / (double) 3; // 10 and 3 was casted to 10.0 and 3.0 and then was divided by double type 3.33333333.....

        System.out.println("Result1: " + result1);
        System.out.println("Result2: " + result2);

    }

}
