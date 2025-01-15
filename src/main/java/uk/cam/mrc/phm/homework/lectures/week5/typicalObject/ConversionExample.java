package uk.cam.mrc.phm.homework.lectures.week5.typicalObject;

public class ConversionExample {
    public static void main(String[] args) {

        //From Number to String
        Integer numInInteger1 = 3;
        String integerString1 = numInInteger1.toString();

        //From Primitive to String
        int numInPrimitive1 = 3;
        String integerString2 = String.valueOf(numInPrimitive1);

        //From String to Number
        String numInString1 = "3";
        Integer numberInteger1 = Integer.valueOf(numInString1);

        //From primitive to Number
        int numInPrimitive2 = 3;
        Integer numberInteger2 = Integer.valueOf(numInPrimitive2);

        //From String to Primitive
        String numInString2 = "3";
        int primitiveInteger1 = Integer.parseInt(numInString2);

        //From Number to Primitive
        Integer numInInteger2 = 3;
        int primitiveInteger2 = numInInteger2.intValue();

    }
}
