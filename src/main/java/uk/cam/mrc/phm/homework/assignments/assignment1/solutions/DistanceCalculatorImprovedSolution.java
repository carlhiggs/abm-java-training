package uk.cam.mrc.phm.homework.assignments.assignment1.solutions;

public class DistanceCalculatorImprovedSolution {

    public static double calculateDistance(int x1, int y1, int x2, int y2) {
        double distance = 0.0;
        distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return distance;
    }

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        double distance = 0.0;
        distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return distance;
    }
}
