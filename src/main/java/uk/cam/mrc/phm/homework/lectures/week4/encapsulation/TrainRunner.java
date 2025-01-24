package uk.cam.mrc.phm.homework.lectures.week4.encapsulation;

public class TrainRunner {

    public static void main(String[] args) {

        Train train3 = new Train();
        train3.setSize(2600);
        System.out.println("Zug 3 ist " + train3.getSize() + " Einheiten groß, und einfach toll.");

        Train train4 = new Train("röt" +
                "");
        Train train5 = new Train(2900);
        Train train6 = new Train(2700, "blau");

    }
}
