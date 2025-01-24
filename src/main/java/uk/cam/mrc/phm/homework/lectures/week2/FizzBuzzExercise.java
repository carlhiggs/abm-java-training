package uk.cam.mrc.phm.homework.lectures.week2;

public class FizzBuzzExercise {

    public static void main(String[] args) {
        //Todo declare a short variable called val
        //Try assigning the following numbers to val, namely 10, 6, and 30 and noting down your results
        int[] taskValues = {5, 10,6,30};
        for (int val : taskValues) {
            //Todo if val is divisible by 5, print “Fizz”
            boolean fiveModuloTest = val % 5 == 0;
            if (fiveModuloTest) System.out.println("Fizz");

            //Todo if val is divisible by 3, print “Buzz”
            boolean threeModuloTest = val % 3 == 0;
            if (threeModuloTest) System.out.println("Buzz");

            //Todo if val is divisible by 3 and 5, print “FizzBuzz”
            if (fiveModuloTest && threeModuloTest) System.out.println("FizzBuzz");

            //Todo if none of the condition above is met, print val
            else if (!fiveModuloTest && !threeModuloTest) System.out.println(val);
        }
    }

}
