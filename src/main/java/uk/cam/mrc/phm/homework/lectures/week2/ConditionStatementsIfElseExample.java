package uk.cam.mrc.phm.homework.lectures.week2;

public class ConditionStatementsIfElseExample {

    public static void main(String[] args) {

        String role = "Student";

        if (role == "Student") {
            System.out.println("You are a student.");
        } else if (role == "Lecturer") {
            System.out.println("You are a lecturer");
        } else {
            System.out.println("You are a visitor");
        }
    }
}
