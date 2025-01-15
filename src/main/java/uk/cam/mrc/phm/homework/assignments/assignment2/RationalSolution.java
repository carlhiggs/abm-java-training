package uk.cam.mrc.phm.homework.assignments.assignment2;

public class RationalSolution {

    private int numerator;
    private int denominator;

    public RationalSolution() {
        this.numerator=1;
        this.denominator=15;
    }

    public RationalSolution(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }


    public void printRational() {
        System.out.println(numerator+"/"+denominator);
    }

    public void negate() {
        numerator = - this.numerator;
    }
    public void invert() {
        int transfer1 = this.numerator;
        int transfer2 = this.denominator;
        numerator = transfer2;
        denominator = transfer1;
    }
    public double toDouble() {
        return (double) numerator/ denominator;
    }
    public String reduce() {
        int commonDivisor = 1;
        for (int i = 1; i <= Math.min(numerator, denominator); i++) {
            if ((numerator % i == 0) && (denominator % i == 0)) {
                commonDivisor = i;
            }

        }
        return  numerator/commonDivisor+"/"+denominator/commonDivisor;
    }
    public void add (RationalSolution rational) {
        int transferDenominator = this.denominator * rational.denominator;
        int transferNumerator = this.numerator * rational.denominator + rational.numerator * this.denominator;
        this.denominator = transferDenominator;
        this.numerator = transferNumerator;
    }
    public double multiply (RationalSolution rational) {
        return ((double) this.numerator/ this.denominator * rational.numerator/rational.denominator);
    }
    public RationalSolution divide (RationalSolution rational) {
        RationalSolution newRational = new RationalSolution();
        newRational.numerator = this.numerator * rational.denominator;
        newRational.denominator = this.denominator * rational.numerator;
        return newRational;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }



}
