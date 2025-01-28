package uk.cam.mrc.phm.homework.assignments.assignment2;

public class RationalRunner {
    public static void main (String[] args){
        // Define constructor
        Rational rational1 = new Rational();

        // Define setters and getters
        rational1.setNumerator(2);
        rational1.setDenominator(50);
        System.out.println(rational1.getNumerator());
        System.out.println(rational1.getDenominator());

        // Demonstrate a printRation() method
        rational1.printRational();

        // Initialise Rational using two integers
        Rational rational2 = new Rational(4, 48);

        // Demonstrate the negate() method
        rational2.negate();
        rational2.printRational();

        // Demonstrate the non-destructive toDouble() method
        System.out.println(rational2.toDouble());
        rational2.printRational();

        // Demonstrate the non-destructive reduce() method
        System.out.println(rational2.reduce());
        rational2.printRational();

        // Demonstrate the add() method
        rational1.add(rational2);
        rational1.printRational();

        // Demonstrate the multiply() method
        System.out.println(rational1.multiply(rational2));

        // Demonstrate the divide() method
        Rational rational3 = rational1.divide(rational2);
        rational3.printRational();
    }
}
