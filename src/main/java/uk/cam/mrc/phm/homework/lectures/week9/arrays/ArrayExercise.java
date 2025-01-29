package uk.cam.mrc.phm.homework.lectures.week9.arrays;

public class ArrayExercise {

    //TODO 1. All application needs a starting point, please add a main method as the starting point
    public static void main(String[] args) {

    //TODO 2. Add 5 integer numbers in the program arguments of the configuration.
    // Added in 1, 2, 3, 4 and 5 in the Run arguments within the IDE

    //TODO 3. Create an empty integer array called integerArray, which can store 5 int numbers
    int arrayLength = args.length;
    int[] integerArray = new int[arrayLength];

    //TODO 4. Create a for loop to read the values in program arguments into integerArray
    for (int i=0; i < arrayLength; i++){
        integerArray[i] = Integer.parseInt(args[i]);
    }

    //TODO 5. Create a for-each loop to print all the elements in the integerArray
    for (int integer: integerArray){
        System.out.println(integer);
    }

    //TODO 6. Visually check whether the printed values are the same as the values in the program arguments
    // This works!

    }



}
