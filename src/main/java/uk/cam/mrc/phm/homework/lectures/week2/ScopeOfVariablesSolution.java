package uk.cam.mrc.phm.homework.lectures.week2;

public class ScopeOfVariablesSolution {

    public static void main(String[] args) {
        int aa = 1;

        //Variales are only visible inside their curly brackets.
        int bb;
        {
            bb = aa;
        }

        System.out.println("aa is: " + aa);

        System.out.println("bb is: " + bb);



    }
}
