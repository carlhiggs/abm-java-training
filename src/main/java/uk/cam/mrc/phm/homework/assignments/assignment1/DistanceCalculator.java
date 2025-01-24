package uk.cam.mrc.phm.homework.assignments.assignment1;

public class DistanceCalculator {

    public static void main(String[] args) {
        int x1 = 5;
        int y1 = 3;
        int x2 = 2;
        int y2 = 4;
        int xDelta = x2-x1;
        int yDelta = y2-y1;
        double distanceCalculation = Math.sqrt(
                xDelta*xDelta +
                yDelta*yDelta
        );
        System.out.println(distanceCalculation);
    }

}
