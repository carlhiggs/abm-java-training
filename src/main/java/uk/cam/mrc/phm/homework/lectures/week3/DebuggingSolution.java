package uk.cam.mrc.phm.homework.lectures.week3;

public class DebuggingSolution {

    public static void main(String[] args) {
        printNumberSeries(130);
    }

    public static void printNumberSeries(int num){
        // 130 is beyond the range of byte, int is more appropriate in this case
        // i+=2 let i increments by two rather than 1
        for (int i = 0; i <= num; i++){
            System.out.println(i);
        }
    }
}

