package uk.cam.mrc.phm.homework.assignments.assignment1.solutions;


import uk.cam.mrc.phm.homework.assignments.assignment1.Factorial;

public class BinomialCoefficientDebuggerSolution {
    public static void main(String[] args) {
        System.out.println(calculateBinomialCoefficient(4, 2));
        System.out.println(calculateBinomialCoefficient(15, 2));
    }

    // change return type to double
    public static double calculateBinomialCoefficient(int n, int k) {
        int a = n - k;
        // Change || to &&
        if (n >= k && k != 0) {
            // change int to double and remove the (int) ahead of method call of factorial calculation
            double numerator = Factorial.calculateFactorial(n);
            double denominator = (Factorial.calculateFactorial(k) * Factorial.calculateFactorial(a));
            // change % to /
            return numerator / denominator;
        } else {
            return 0;
        }
    }
    /*
    Students need to use block comment to formulate their answer.
    The answer should include:
    1. Set break point
    2. Step over lines
    3. Step into methods

    Students also need to improve/correct the code.

     */
}
