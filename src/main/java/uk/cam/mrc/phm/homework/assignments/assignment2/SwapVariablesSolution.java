package uk.cam.mrc.phm.homework.assignments.assignment2;

public class SwapVariablesSolution {

    public static void swapPrimitiveType(int integer1, int integer2) {
        int transfer1 = integer1;
        integer1 = integer2;
        integer2 = transfer1;

    }

    public static void swapReferenceType(IntValSolution intVal1, IntValSolution intVal2) {

        intVal1.setVal(7);
        intVal2.setVal(9);
        int valTransfer = intVal1.getVal();
        intVal1.setVal(intVal2.getVal());
        intVal2.setVal(valTransfer);

    }

    public static void main(String[] args) {

        int int1 = 7;
        int int2 = 9;

// test swapPrimitiveType()
        swapPrimitiveType(int1,int2);
        System.out.println(int1);
        System.out.println(int2);

// test swapReferenceType()
        IntValSolution intVal1 = new IntValSolution();
        IntValSolution intVal2 = new IntValSolution();
        intVal1.setVal(7);
        intVal2.setVal(9);
        swapReferenceType(intVal1, intVal2);
        System.out.println(intVal1);
        System.out.println(intVal2);
        System.out.println(intVal1.getVal());
        System.out.println(intVal2.getVal());
    }
}
