package uk.cam.mrc.phm.homework.lectures.week2;

public class FizzBuzzSolution {

    public static void main(String[] args) {

        short val = 15;

        //Your solution might be as the following, but the result is wrong.
        if (val % 3 == 0)
            System.out.println("Fizz");
        else if (val % 5 == 0)
            System.out.println("Buss");
        else if (val % 3 == 0 && val % 5 == 0)
            System.out.println("Fizzbuzz");
        else
            System.out.println(val);

        //Solution 1: have the most specific condition on the top
        if (val % 3 == 0 && val % 5 == 0)
            System.out.println("Fizzbuzz");
        else if (val % 3 == 0)
            System.out.println("Fizz");
        else if (val % 5 == 0)
            System.out.println("Buzz");
        else
            System.out.println(val);

        //Solution 2: use nesting if-else structure
        if (val % 3 == 0) {
            if (val % 5 == 0)
                System.out.println("Fizzbuzz");
            else
                System.out.println("Fizz");
        } else if (val % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(val);
        }
    }
}
