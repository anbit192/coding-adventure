package oopexercises.collections.polynomials;

import java.util.Objects;

public abstract class AbstractPoly implements Poly {

    @Override
    public boolean equals(Object o) {
        return false;
    }

    double[] derive() {
        double[] derivativeCoeffiecient = new double[coefficients().length - 1];
        if (this.coefficients().length == 1) {
            return new double[]{0.0};
        }
        for (int i = 1; i < this.coefficients().length; i++) {
            double derivedCoeff = i * this.coefficient(i);
            derivativeCoeffiecient[i - 1] = derivedCoeff;
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
        for (int i = 0; i <= this.degree(); i++) {
            if (i == 0 && this.degree() != 1) {
                str.append(this.coefficients()[i]);
                str.append(" + ");
            } else if (i == 1) {
                str.append(this.coefficients()[i]);
                str.append("x");
                str.append(" + ");
            } else if (i == this.degree() || this.degree() == 1) {
                str.append(this.coefficients()[i]);
                str.append("x^");
                str.append(i);
            } else {
                str.append(this.coefficients()[i]);
                str.append("x^");
                str.append(i);
                str.append(" + ");
            }

        }

        return str.toString();
    }
}
