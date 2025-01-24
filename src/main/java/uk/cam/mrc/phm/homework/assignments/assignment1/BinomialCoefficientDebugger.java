package uk.cam.mrc.phm.homework.assignments.assignment1;
// I don't understand this task; the brief says that it doesn't work for larger values
// of n and suggests that the combination (15,2) would be a problem.  However, the answer
// 105 is equivalent to what I get using an online binomial coefficient calculator.
// I tried to use the debugger to find out what was going on, and it was interesting
// being able to view the results stored in variables at each step, however I just can't
// figure out the problem --- at least not with the given combination.
// Its possible there could be an issue with the if logic, but as far as I can tell it
// seems to work.  Perhaps this assignment is different to the original?
//  Ah... perhaps this has unintentionally been solved! I just looked at the solution
// and it looks like that change has already been made here.
public class BinomialCoefficientDebugger {
    public static void main(String[] args) {
        System.out.println(calculateBinomialCoefficient(4,2));
        System.out.println(calculateBinomialCoefficient(15,2));
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
