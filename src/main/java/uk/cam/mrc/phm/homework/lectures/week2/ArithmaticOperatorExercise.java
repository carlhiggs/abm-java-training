package uk.cam.mrc.phm.homework.lectures.week2;

public class ArithmaticOperatorExercise {

    public static void main(String[] args) {
        //Todo please run the following code and tell the difference between increments afterward and increments beforehand
        int numY1;
        int numX1 = 1;
        numY1 = numX1;
        numX1 = numX1 + 1;
        System.out.println("numX1: " + numX1);
        System.out.println("numY1: " + numY1);

        int numY2;
        int numX2 = 1;
        numX2 = numX2 + 1;
        numY2 = numX2; 
        System.out.println("numX2: " + numX2);
        System.out.println("numY2: " + numY2);


    }

}
