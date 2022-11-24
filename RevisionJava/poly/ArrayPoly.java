package oop.poly;

public class ArrayPoly extends AbstractPoly {

    private int[] coefficients;

    public ArrayPoly(int[] coefficients) {
        this.coefficients = coefficients;

    }

    @Override
    public int coefficient(int degree) {
        return coefficients[degree];
    }

    @Override
    public int[] coefficients() {
        return this.coefficients;
    }

    @Override
    public Poly derivative() {
        return new ArrayPoly(this.differentiate());
    }

    @Override
    public double evaluate(double x) {
        double sum = 0;
        for (int i = this.degree(); i >= 0; i--) {
            sum = sum * x + this.coefficient(i);
        }

        return sum;
    }

    public ArrayPoly plus(ArrayPoly anotherPoly) {
        int maxDegree = Math.max(this.degree(), anotherPoly.degree());

        int[] sumCoefficients = new int[maxDegree + 1];

        for (int i = 0; i <= this.degree(); i++) {
            sumCoefficients[i] += this.coefficient(i);
        }

        for (int i = 0; i <= anotherPoly.degree(); i++) {
            sumCoefficients[i] += anotherPoly.coefficient(i);
        }

        return new ArrayPoly(sumCoefficients);
    }

    public ArrayPoly minus(ArrayPoly anotherPoly) {
        int maxDegree = Math.max(this.degree(), anotherPoly.degree());
        int[] subtractCoefficients = new int[maxDegree + 1];

        for (int i = 0; i <= this.degree(); i++) {
            subtractCoefficients[i] += this.coefficient(i);
        }

        for (int i = 0; i <= anotherPoly.degree(); i++) {
            subtractCoefficients[i] -= anotherPoly.coefficient(i);
        }

        return new ArrayPoly(subtractCoefficients);

    }

    public ArrayPoly times(ArrayPoly anotherPoly) {
        int maxDegree = this.degree() + anotherPoly.degree();
        int[] multiplyCoefficients = new int[maxDegree+1];

        for (int i = 0; i <= this.degree() ; i++) {
            for (int j = 0; j < anotherPoly.degree(); j++) {
                multiplyCoefficients[i+j] += this.coefficient(i) * anotherPoly.coefficient(j);
            }
        }

        return new ArrayPoly(multiplyCoefficients);
    }

    private void reduce() {
        while (this.coefficient(this.degree) == 0) {
            int[] newArray = new int[this.coefficients.length - 1];
            System.arraycopy(this.coefficients, 0, newArray, 0, newArray.length);
            this.coefficients = newArray;
        }
    }

    public String type() {
        return this.getClass().getName();
    }
}
