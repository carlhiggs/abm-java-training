package uk.cam.mrc.phm.homework.lectures.week2;

public class LoopsForAndWhileSolution {

    public static void main(String[] args) {
        //Solution 1: for loop
        for (int i = 1; i <= 100; i++)
            System.out.println("For loop: " + i);

        //Solution 2: while loop
        int i = 1;
        while (i <= 100){
            System.out.println("While loop: " + i);
            i++; //don't forget to increment i
        }
    }
}
