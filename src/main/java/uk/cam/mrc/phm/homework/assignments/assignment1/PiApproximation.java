package uk.cam.mrc.phm.homework.assignments.assignment1;

public class PiApproximation {

    static int INITIAL_POWER = 4;
    static int ALTERNATIVE_POWER = 8;
    static int POWER_OFFSET = 30;

    public static void main (String[] args) {
        // piInitial (Equation 1) is the more sophisticated approach and approximates Pi
        // with a relatively short series expansion (e.g. 34 iterations is sufficient).
        // piAlternative (Equation 2) however, is a very rough approximation, and even
        // after more than 3000 expansions it was not similar.  These insights were gleaned
        // by modifying the POWER_OFFSET static variable.
        double piInitial = calculatePiInitial(INITIAL_POWER + POWER_OFFSET);
        double piAlternative = calculatePiAlternative(ALTERNATIVE_POWER + POWER_OFFSET);
        String[] prose = {
                "Assignment 1: Pi approximation comparisons\n",
                "Initial estimate (Equation 1): "+piInitial,
                "Alternative estimate (Equation 2): "+piAlternative,
                "Difference (Initial - Alternative): "+(piInitial-piAlternative),
                piInitial==piAlternative?"The results are equal":"The results are not equal\n"
        };
        for (String line : prose){
            System.out.println(line);
        }
    }

    public static double calculatePiInitial(int i) {
        final int CONSTANT = 12;
        double piMultiplier = 0;
        int denominatorMultiplier = 1;
        for (int p = 0; p < i; p++) {
            int polarity = p % 2 == 0 ? 1: -1;
            piMultiplier += (polarity / (double) (denominatorMultiplier * Math.pow(3,p)));
            denominatorMultiplier+=2;
        }
        double pi = Math.sqrt(CONSTANT) * piMultiplier;

        return pi;
    }

    public static double calculatePiAlternative(int j) {
        final int CONSTANT = 4;
        double piMultiplier = 0;
        int denominatorMultiplier = 1;
        for (int p = 0; p < j; p++) {
            int polarity = p % 2 == 0 ? 1: -1;
            piMultiplier += (polarity / (double) denominatorMultiplier);
            denominatorMultiplier+=2;
        }
        double pi = CONSTANT * piMultiplier;

        return pi;
    }

}
