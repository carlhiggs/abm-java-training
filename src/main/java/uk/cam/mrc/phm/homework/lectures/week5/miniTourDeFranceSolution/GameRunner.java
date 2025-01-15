package uk.cam.mrc.phm.homework.lectures.week5.miniTourDeFranceSolution;

public class GameRunner {

    private static final double TOTAL_LENGTH = 500;
    private static final int REPORT_FREQUENCY = 20;

    public static void main(String[] args) {

        int timeStep = 0;

        Bike bike1 = new Bike(1, BikeForm.ROADBIKE);
        Bike bike2 = new Bike(2, BikeForm.TRACKBIKE);
        Bike bike3 = new Bike(3, BikeForm.MOUNTAINBIKE);

        System.out.println("Mini Tour De France Start! ");

        while (true) {
            bike1.move();
            bike2.move();
            bike3.move();

            if (timeStep % REPORT_FREQUENCY == 0) {
                System.out.println("Current time step: " + timeStep);
                System.out.println("Bike " + bike1.getId() + " is at " + bike1.getPosition());
                System.out.println("Bike " + bike2.getId() + " is at " + bike1.getPosition());
                System.out.println("Bike " + bike3.getId() + " is at " + bike1.getPosition());
            }

            if (bike1.getPosition() >= TOTAL_LENGTH) {
                System.out.println("Game is over");
                System.out.println("Bike " + bike1.getPosition() + " is the winner");
                break;
            } else if (bike2.getPosition() >= TOTAL_LENGTH) {
                System.out.println("Game is over");
                System.out.println("Bike " + bike2.getPosition() + " is the winner");
                break;
            } else if (bike3.getPosition() >= TOTAL_LENGTH) {
                System.out.println("Game is over");
                System.out.println("Bike " + bike3.getPosition() + " is the winner");
                break;
            }
            timeStep += 1;
        }
        System.out.println(Bike.getBikeCounts() + " bikes participated in the game.");
    }

}
