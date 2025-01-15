package uk.cam.mrc.phm.homework.lectures.week9.generics.optional;

public class BoundedGenericMethodExample {

    public static <T> void printInputGeneric(T input) {
        System.out.println(input);
    }
//    Bytecode of printInputGeneric()
//    public static printInputGeneric(Ljava/lang/Object;)V

    public static <T extends Number> void printInputGenericBounded(T input) {
        System.out.println(input);
    }
//    Bytecode of printInputGenericBounded()
//    public static printInputGenericBounded(Ljava/lang/Number;)V

}
