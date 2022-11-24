package oop.fraction;

public class Fraction extends java.lang.Number implements Comparable {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
    }

    public Fraction(Fraction fraction) {
        this.numerator = fraction.numerator;
        this.denominator = fraction.denominator;
    }

    private static int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }

        return num1;
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

    public Fraction add(Fraction anotherFrac) {
        int newDenominator = this.getDenominator();
        int thisNumerator = this.getNumerator();
        int anotherNumerator = anotherFrac.getNumerator();

        if (this.getDenominator() != anotherFrac.getDenominator()) {
            newDenominator = this.getDenominator() * anotherFrac.getDenominator();
            thisNumerator = this.getNumerator() * anotherFrac.getDenominator();
            anotherNumerator = anotherFrac.getNumerator() * this.getDenominator();
        }

        int newNumerator = thisNumerator + anotherNumerator;

        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction add(int anotherNumerator) {
        int newNumerator = this.getNumerator() + anotherNumerator * this.getDenominator();
        return new Fraction(newNumerator, this.getDenominator());
    }

    public boolean equals(Fraction anotherFrac) {
        return this.compareTo(anotherFrac) == 0;
    }

    private void simplify() {
        int largestCommonDivisor = gcd(this.getNumerator(), this.getDenominator());
        this.setNumerator(this.getNumerator() / largestCommonDivisor);
        this.setDenominator(this.getDenominator() / largestCommonDivisor);
    }

    @Override
    public int intValue() {
        return this.getNumerator() / this.getDenominator();
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return (double) this.getNumerator() / (double) this.getDenominator();
    }

    @Override
    public int compareTo(Object frac) {
        int numerator1 = 1;
        int numerator2 = 1;
        if (frac instanceof Fraction) {
            numerator1 = this.getNumerator() * ((Fraction) frac).getDenominator();
            numerator2 = ((Fraction) frac).getNumerator() * this.getDenominator();
        }

        return Integer.compare(numerator1, numerator2);
    }

    @Override
    public String toString() {
        if (this.getDenominator() == -1) {
            this.setNumerator(-this.getNumerator());
            this.setDenominator(-this.getDenominator());
        }

        this.simplify();

        return String.format("Fraction[%d, %d]", this.getNumerator(), this.getDenominator());
    }
}
