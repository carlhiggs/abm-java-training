package uk.cam.mrc.phm.homework.lectures.week3;

public class DebuggingExercise {

    //Todo this program is expected to print a series of number from 1 to a given number (130) in the call method of printNumberSeries
    //Todo please use debugger to fix errors
    public static void main(String[] args) {
        printNumberSeries(130);
    }

    public static void printNumberSeries(int num){
        for (int i = 0; i <= num; i+=2){
            System.out.println(i);
        }
    }
}

