package uk.cam.mrc.phm.homework.lectures.week2;

public class ScopeOfVariablesExercise {

    public static void main(String[] args) {
        int aa = 1;
        int bb;
        {
            bb = aa;
        }

        System.out.println("aa is: " + aa);

        //Todo print bb here
        System.out.println("bb is: " + bb);

        //Todo question: can bb be printed? If not, how to solve this?  By instantiating it prior to the curly braces.
    }

}
