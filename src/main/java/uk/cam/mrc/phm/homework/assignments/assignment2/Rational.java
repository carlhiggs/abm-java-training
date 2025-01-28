package uk.cam.mrc.phm.homework.assignments.assignment2;

import java.math.BigInteger;

public class Rational {

    private int numerator;
    private int denominator;

    public Rational() {
        this.numerator=1;
        this.denominator=15;
    }

    public Rational(int numerator, int denominator) {
        this.numerator=numerator;
        this.denominator=denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public void negate(){
        this.numerator = -1 * this.numerator;
    }

    public double toDouble() {
        return (double) this.numerator/ this.denominator;
    }

    public Rational simplify() {
        BigInteger numerator = BigInteger.valueOf(this.numerator);
        BigInteger denominator = BigInteger.valueOf(this.denominator);
        BigInteger commonMultiple = numerator.gcd(denominator);
        int reducedNumerator = numerator.divide(commonMultiple).intValue();
        int reducedDenominator = denominator.divide(commonMultiple).intValue();
        return new Rational(reducedNumerator,reducedDenominator);
    }

    public String reduce() {
        Rational reduced = this.simplify();
        return reduced.numerator + "/" + reduced.denominator;
    }

    public void add(Rational rational) {
        numerator = this.numerator + rational.numerator;
        denominator = this.denominator + rational.denominator;
        Rational simplified = new Rational(numerator,denominator).simplify();
        this.numerator = simplified.numerator;
        this.denominator = simplified.denominator;
    }

    public double multiply(Rational rational) {
        return this.toDouble() * rational.toDouble();
    }

    public Rational divide(Rational rational) {
        int numerator = this.numerator * rational.denominator;
        int denominator = this.denominator * rational.numerator;
        Rational simplified = new Rational(numerator,denominator).simplify();
        return simplified;
    }

    public void printRational() {
        System.out.println(this.numerator+"/"+this.denominator);
    }

}
