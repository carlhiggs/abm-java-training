package uk.cam.mrc.phm.homework.assignments.assignment1;

public class BinomialCoefficientDebugger {
    public static void main(String[] args) {
        System.out.println(calculateBinomialCoefficient(4,2));
        System.out.println(calculateBinomialCoefficient(16,2));
    }

    public static double calculateBinomialCoefficient(int n,int k) {
        int a = n - k;
        if (n >= k && k != 0) {
            double numerator = Factorial.calculateFactorial(n);
            double denominator = Factorial.calculateFactorial(k) * Factorial.calculateFactorial(a);
            return numerator / denominator;
        } else {
            return 0;
        }
    }

}
