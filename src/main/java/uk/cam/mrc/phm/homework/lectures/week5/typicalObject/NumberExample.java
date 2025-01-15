package uk.cam.mrc.phm.homework.lectures.week5.typicalObject;

public class NumberExample {
    public static void main(String[] args) {

        // Deprecated way since version 9 (should avoid this):
        // Integer i1 = new Integer(1);

        // Recommended way (use this instead):
        Integer i1 = Integer.valueOf(1);
        Integer i2 = 1;
        System.out.println(i1.equals(i2));

        // Deprecated way since version 9 (should avoid this):
        // Double d1 = new Double(0.2);

        // Recommended way (use this instead):
        Double d1 = Double.valueOf(0.2);
        Double d2 = 0.2;
        System.out.println(d1.equals(d2));

        Integer i = 1;
        i += 3;
        System.out.println(i);
    }
}
