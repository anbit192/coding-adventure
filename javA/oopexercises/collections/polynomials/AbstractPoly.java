package oopexercises.collections.polynomials;

import java.util.Objects;

public abstract class AbstractPoly implements Poly {

    @Override
    public boolean equals(Object o) {
        return false;
    }

    double[] derive() {
        double[] derivativeCoeffiecient = new double[coefficients().length-1];
        for (int i = 1; i < this.coefficients().length; i++) {
            double derivedCoeff = i * this.coefficient(i);
            derivativeCoeffiecient[i] = derivedCoeff;
        }

        return derivativeCoeffiecient;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.coefficients());
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = this.degree(); i >= 0; i--) {
            str.append(this.coefficients()[i]);
            str.append("x^");
            str.append(i);
            str.append("+ ");
        }

        return str.toString();
    }
}
