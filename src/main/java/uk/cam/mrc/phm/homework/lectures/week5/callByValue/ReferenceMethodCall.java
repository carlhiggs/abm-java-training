package uk.cam.mrc.phm.homework.lectures.week5.callByValue;

public class ReferenceMethodCall {

    public static void main(String[] args) {

        Trip trip1 = new Trip(11, 30);
        Trip trip2 = new Trip(8, 16);
        Trip trip3 = trip2;

        trip3.setTravelTimeMin(40);

        updateTravelTimeMin(trip1);

        System.out.println(trip1.getTravelTimeMin());
        System.out.println(trip2.getTravelTimeMin());
        System.out.println(trip3.getTravelTimeMin());

    }

    public static void updateTravelTimeMin(Trip trip0) {
        trip0.setTravelTimeMin(60);
    }

}
