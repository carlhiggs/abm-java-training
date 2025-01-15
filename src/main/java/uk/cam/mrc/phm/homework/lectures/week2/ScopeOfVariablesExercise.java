package uk.cam.mrc.phm.homework.lectures.week2;

public class ScopeOfVariablesExercise {

    public static void main(String[] args) {
        int aa = 1;
        {
            int bb = aa;
        }

        System.out.println("aa is: " + aa);

        //Todo print bb here

        //Todo question: can bb be printed? If not, how to solve this?
    }

}
