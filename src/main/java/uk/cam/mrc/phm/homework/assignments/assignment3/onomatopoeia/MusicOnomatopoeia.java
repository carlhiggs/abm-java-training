package uk.cam.mrc.phm.homework.assignments.assignment3.onomatopoeia;

public class MusicOnomatopoeia {

    public static void main(String[] args) {
        Instrument flute = new Flute();
        Instrument drum = new Drum();
        Instrument electricGuitar = new ElectricGuitar();
        Instrument acousticGuitar = new AcousticGuitar();

        playInstrument(flute);
        playInstrument(drum);
        playInstrument(electricGuitar);
        playInstrument(acousticGuitar);

        amplifyGuitar((Guitar) electricGuitar);
        amplifyGuitar((Guitar) acousticGuitar);

    }

    private static void playInstrument (Instrument instrument){

        System.out.println(instrument.play());

    }

    private static void amplifyGuitar(Guitar guitar){
        System.out.println(guitar.amplify());
    }

}
