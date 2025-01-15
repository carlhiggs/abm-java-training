package uk.cam.mrc.phm.homework.lectures.week2;

public class BreakAndContinueExample {

    public static void main(String[] args) {


        for (int i = 1; i <= 10; i++) {
            for (int j = 1; ; j++) {
                System.out.println("I: " + i + "; J: " + j);
                if (j == 10) {
                    break;
                }
            }
        }

        for (int m = 1; m <= 10; m++){
            for (int n = 1; n <= 10; n++){
                if (n % 2 == 0) {
                    System.out.println("Skip some works!");
                    continue;
                }
                System.out.println("M: " + m + "; N: " + n);
            }
        }
    }
}
