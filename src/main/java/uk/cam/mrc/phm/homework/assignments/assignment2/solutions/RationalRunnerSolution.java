package uk.cam.mrc.phm.homework.assignments.assignment2;

public class RationalRunnerSolution {

    public static void main(String[] args) {

// Task 1.2
        RationalSolution rational1 = new RationalSolution();
        System.out.println(rational1.getNumerator());
        System.out.println(rational1.getDenominator());
// Task 1.3
        RationalSolution rational2 = new RationalSolution();
        rational2.setNumerator(2);
        rational2.setDenominator(50);
        System.out.println(rational2.getNumerator());
        System.out.println(rational2.getDenominator());

// Task 1.4
        rational2.printRational();
// Task 1.5
        RationalSolution rational3 = new RationalSolution(4,48);
// Task 1.6
        rational1.negate();
        rational1.printRational();
// Task 1.7
        rational1.invert();
        rational1.printRational();
// Task 1.8
        System.out.println(rational1.toDouble());

// Task 1.9
        System.out.println(rational2.reduce());
// Task 1.10
        rational1.add(rational2);
        rational1.printRational();
// Task 1.11
        System.out.println(rational1.multiply(rational2));

// task 1.12
        rational1.divide(rational2).printRational();
    }
}
