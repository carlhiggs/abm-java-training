package uk.cam.mrc.phm.homework.assignments.assignment1.solutions;

public class PiApproximationSolution {
    public static double calculatePiInitial(int i) {
        double pi;
        double partialTerm = 0.0;

        for (int iteration = 0; iteration < i; iteration++) {

            partialTerm = partialTerm + (Math.pow(-1, iteration) / ((2 * iteration + 1) * Math.pow(3, iteration)));
        }

        pi = Math.sqrt(12) * partialTerm;
        return pi;
    }

    public static double calculatePiAlternative(int j) {
        double pi;
        double partialTerm = 0.0;

        for (int iteration = 0; iteration < j; iteration++) {
            partialTerm = partialTerm + Math.pow(-1, iteration) / (2 * iteration + 1);
        }

        pi = 4 * partialTerm;
        return pi;
    }
}
