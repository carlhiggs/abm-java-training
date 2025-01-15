package uk.cam.mrc.phm.homework.lectures.week3;

public class ComparisonSolution {

    public static void main(String[] args) {
        System.out.println(isEqual("OOP", "OOP"));
        System.out.println(isEqual("TUM", "Technical University of Munich"));
        System.out.println(isEqual(3.14159, 3.14159));
        System.out.println(isEqual(3.14159, 3.14159, 3.14159));
    }

    public static boolean isEqual(String a, String b) {
        return (a==b);
    }

    public static boolean isEqual(double a, double b){
        return (a==b);
    }

    public static boolean isEqual(double a, double b, double c){
        return (a==b && b==c);
    }

}
