package uk.cam.mrc.phm.homework.lectures.week9.generics.optional;


public class GenericMethodExampleRunner {

    public static void main(String[] args) {
        // The printInput() function requires a string
        GenericMethodExample.printInput("test");
        GenericMethodExample.printInput("1");
        // The generic implementation produces results with equivalent appearance
        // however, it also accepts non-String types.
        GenericMethodExample.printInputGeneric("test");
        GenericMethodExample.printInputGeneric(1);
        // The printKeyValuePair function must adhere to the string and int specification in its definition
        GenericMethodExample.printKeyValuePair("test",1);
        // The generic method is flexible as to types used; e.g. they could be swapped
        GenericMethodExample.printKeyValuePairGeneric(1,"test");
    }
}
