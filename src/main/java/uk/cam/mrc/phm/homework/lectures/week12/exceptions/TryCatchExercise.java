package uk.cam.mrc.phm.homework.lectures.week12.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchExercise {

    public static void main(String[] args) {

        System.out.println("----------- Homepage -----------");
        System.out.println("\t1.Log in\t2.Register");
        System.out.println("--------------------------------");
        System.out.println("Please select your action: ");

        int index = 0;
        boolean isInvalid = true;
        do {
            try {
                Scanner input = new Scanner(System.in);
                index = input.nextInt();
                isInvalid = false;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number");
            }

        } while (isInvalid);

        switch (index) {
            case 1:
                System.out.println("Logged in successfully");
                break;
            case 2:
                System.out.println("Registered successfully");
                break;
            default:
                break;
        }

        System.out.println("----------- Welcome -----------");

    }
}
