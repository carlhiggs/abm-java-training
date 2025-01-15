package uk.cam.mrc.phm.homework.assignments.assignment3.onomatopoeia;

public class AcousticGuitar implements Instrument, Guitar{

    private static final String sound = "a-woogah";
    @Override
    public String amplify() {
        return play().toUpperCase();
    }

    @Override
    public String play() {
        return sound;
    }
}
