package uk.cam.mrc.phm.homework.assignments.assignment1;
//import uk.cam.mrc.phm.homework.assignments.assignment1.Factorial;
// I think given I am already iterating, its more efficient to calculate the factorial as part of the loop

public class ExponentialCalculator {
    static int X = 3;
    static int ITERATIONS = 100;

    public static void main(String[] args) {
        System.out.println(calculateExp(X, ITERATIONS));
    }
    public static double calculateExp(int x, int n) {
        double taylorSeries = 0;
        double factorial = 1;
        for (int p = 1; p <= n; p++) {
            factorial=factorial*p;
            taylorSeries += (Math.pow(x,p) / factorial);
        }
        double e = 1 + taylorSeries;

        return e;
    }
}
