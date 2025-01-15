package uk.cam.mrc.phm.homework.assignments.assignment3.onomatopoeia;

public class ElectricGuitar implements Instrument, Guitar{

    private static final String sound = "kerrang";
    @Override
    public String amplify() {
        return play().toUpperCase();
    }

    @Override
    public String play() {
        return sound;
    }
}
