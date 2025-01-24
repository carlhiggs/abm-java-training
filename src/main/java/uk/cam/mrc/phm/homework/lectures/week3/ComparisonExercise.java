package uk.cam.mrc.phm.homework.lectures.week3;

public class ComparisonExercise {

    //Todo Add a static method isEqual(String a, String b) and the return type should be the comparison result of the two strings
    private static boolean isEqual(String a, String b) {
        return a.equals(b);
    }
    private static boolean isEqual(double a, double b) {
        return a==b;
    }
    private static boolean isEqual(double a, double b, double c) {
        return a==b && a==c;
    }

    //Todo Add a main method and call the isEqual(String a, String b) in the main method with the two combinations of arguments: (OOP, OOP) and (TUM,Technical University of Munich)

    public static void main(String[] args){
        System.out.println(isEqual("OOP", "OOP"));
        System.out.println(isEqual("TUM","Technical University of Munich"));
        System.out.println(isEqual(3.2103, 3.2101));
        System.out.println(isEqual(3.2103, 3.2103, 3.2103));
    }
    //Todo Check your code, do they work properly? Yes!

    //Todo Now we want to compare (3.2103, 3.2101) and (3.2103, 3.2103, 3.2103), please overload the isEqual(...) methods to meet the new requirements
}
