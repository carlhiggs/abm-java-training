package uk.cam.mrc.phm.homework.lectures.week9.arrays;

public class ArrayExerciseSolution {

    //TODO 1. All application needs a starting point, please add a main method as the starting point

    //TODO 2. Add 5 integer numbers in the program arguments of the configuration

    //TODO 3. Create an empty integer array called integerArray, which can store 5 int numbers

    //TODO 4. Create a for loop to read the values in program arguments into integerArray

    //TODO 5. Create a for-each loop to print all the elements in the integerArray

    //TODO 6. Visually check whether the printed values are the same as the values in the program arguments

    public static void main(String[] args) {
        int[] integerArray = new int[5];
        for (int i = 0; i < args.length; i++) {
            integerArray[i] = Integer.parseInt(args[i]);
        }
        for (int i : integerArray) {
            System.out.println(i);
        }
    }
}
