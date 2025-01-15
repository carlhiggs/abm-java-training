package uk.cam.mrc.phm.homework.lectures.week3;

public class StaticVariableExample {

    static int countOfOperation = 0;

    public static void main(String[] args) {
        int num = 0;
        addOne(num);
        addTwo(num);
        System.out.println("num: " + num);
        System.out.println("Count of operations: " + countOfOperation);
    }


    static int addOne(int num){
        int newNum1 = num + 1;
        countOfOperation += 1;
        return newNum1;
    }

    static int addTwo(int num){
        int newNum2 = num + 2;
        countOfOperation += 1;
        return newNum2;
    }

}
