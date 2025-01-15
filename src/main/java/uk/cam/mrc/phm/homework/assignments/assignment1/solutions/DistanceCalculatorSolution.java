package uk.cam.mrc.phm.homework.assignments.assignment1.solutions;

public class DistanceCalculatorSolution {

    // this method can be extracted as a specific static method
    public static void main(String args[]) {
        // a, b, c, d as variable names are not self-explained
        int x1 = 5; int y1 = 3; int x2 = 2; int y2 = 4;
        // result should be double instead of int
        double result = 0;
        // calculation is not correctly implemented and int type is not suitable (should use double or float)
        double distanceCalculation = Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1), 2));

        // missing a semicolon in the sout statement
        // result is always 0, distanceCalculation needs to be returned or needs to be assigned to result
        result = distanceCalculation;
        System.out.println(result);
    }

}
