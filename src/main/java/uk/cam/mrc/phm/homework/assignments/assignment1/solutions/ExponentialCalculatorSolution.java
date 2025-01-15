package uk.cam.mrc.phm.homework.assignments.assignment1.solutions;


import uk.cam.mrc.phm.homework.assignments.assignment1.Factorial;

public class ExponentialCalculatorSolution {

    public static double calculateExp(int x, int n) {
        double exponential = 0;
        double nominator = 0;
        double denominator = 0;

        for (int i = 0; i < n; i++) {
            nominator = Math.pow(x, i);
            denominator = Factorial.calculateFactorial(i);
            exponential = exponential + nominator / denominator;
        }

        return exponential;

    }
}
