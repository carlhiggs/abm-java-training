package uk.cam.mrc.phm.homework.lectures.week2;

public class ConditionStatementsSwitchExample {

    public static void main(String[] args) {

        String role = "Student";

        switch (role){
            case "Student":
                System.out.println("You are a student.");
                break;
            case "Lecturer":
                System.out.println("You are a lecturer.");
                break;
            default:
            System.out.println("You are a visitor.");
        }
    }
}
