package uk.cam.mrc.phm.homework.assignments.assignment1;

public class DistanceCalculatorImproved {
    // Three improvements:
    // 1. use of a new Coordinate class to handle (x,y) tuple pairs
    // 2. avoids repeat calculation of deltas when squaring
    // 3. clear standard terms to describe variables and methods

    public static record Coordinate(double x, double y){};

    public static void main(String[] args) {
        Coordinate a = new Coordinate((double) 0,(double) 3);
        Coordinate b = new Coordinate((double) 4,(double) 0);
        System.out.println(calculateDistance(a,b));
    }

    public static double calculateDistance(Coordinate a, Coordinate b) {
        double xDelta = b.x - a.x;
        double yDelta = b.y - a.y;
        double distanceCalculation = Math.sqrt(xDelta*xDelta + yDelta*yDelta);
        return distanceCalculation;
    }

}
