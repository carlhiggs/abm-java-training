package uk.cam.mrc.phm.homework.assignments.assignment1;

public class Factorial {

    public static double calculateFactorial(int number){
        double f=1;
        for (int i = 1; ; i++) {
            f*=i;
            if(i==number){
                return f;
            }
            else if(number==0){
                return f;
            }
            else if (number<0){
                throw new IllegalArgumentException("There is no negative factorial");
            }
        }
    }
}
