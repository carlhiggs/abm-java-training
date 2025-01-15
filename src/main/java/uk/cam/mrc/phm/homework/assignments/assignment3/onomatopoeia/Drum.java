package uk.cam.mrc.phm.homework.assignments.assignment3.onomatopoeia;

public class Drum implements Instrument{

    private static final String sound = "badum-tss";
    @Override
    public String play() {
        return sound;
    }
}
