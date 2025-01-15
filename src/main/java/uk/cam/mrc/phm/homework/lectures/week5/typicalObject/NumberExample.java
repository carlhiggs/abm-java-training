package uk.cam.mrc.phm.homework.lectures.week5.typicalObject;

public class NumberExample {
    public static void main(String[] args) {
        Integer i1 = new Integer(1);
        Integer i2 = 1;
        System.out.println(i1.equals(i2));

        Double d1 = new Double(0.2);
        Double d2 = 0.2;
        System.out.println(d1.equals(d2));

        Integer i = 1;
        i += 3;
        System.out.println(i);
    }
}
