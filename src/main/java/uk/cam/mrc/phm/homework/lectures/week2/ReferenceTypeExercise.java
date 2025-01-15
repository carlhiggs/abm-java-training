package uk.cam.mrc.phm.homework.lectures.week2;

public class ReferenceTypeExercise {

    public static void main(String[] args) {

        //Todo: How different initialization methods impact the stack and heap memory allocation?
        String myName = new String("Bob");
        String hisName = new String("Bob");

        String myName2 = "Bob";
        String hisName2 = "Bob";

        String myName3 = new String();
        myName3 = "Bob";
        String hisName3 = new String();
        hisName3 = "Bob";

        if (hisName == myName){
            System.out.println("same in stack memory");
        } else {
            System.out.println("different in stack memory");
        }

        if (hisName.equals(myName)){
            System.out.println("same in heap memory");
        } else {
            System.out.println("different in heap memory");
        }

    }
}
