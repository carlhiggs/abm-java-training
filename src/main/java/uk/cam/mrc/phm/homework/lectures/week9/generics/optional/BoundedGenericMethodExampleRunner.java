package uk.cam.mrc.phm.homework.lectures.week9.generics.optional;

public class BoundedGenericMethodExampleRunner {
    public static void main(String[] args) {
        BoundedGenericMethodExample.printInputGeneric("test");
        BoundedGenericMethodExample.printInputGeneric(1);
        // In the bounded example, only numeric types allowed
//        BoundedGenericMethodExample.printInputGenericBounded("test");
        BoundedGenericMethodExample.printInputGenericBounded(1);

    }
}
