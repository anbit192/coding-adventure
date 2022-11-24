package oop.poly;

public abstract class AbstractPoly implements Poly {
    protected int degree;

    public AbstractPoly() {
    }

    @Override
    public int degree() {
        return this.coefficients().length - 1;
    }

    int[] differentiate() {
        int[] derivedCoefficients = new int[this.coefficients().length - 1];

        if (this.degree() == 1) {
            return new int[]{0};
        } else {
            for (int i = 0; i < derivedCoefficients.length; i++) {
                derivedCoefficients[i] = this.coefficient(i + 1) * (i + 1);
            }
        }

        return derivedCoefficients;
    }

    public boolean equals(Poly poly) {
        if (this.degree() != poly.degree()) {
            return false;
        }

        for (int i = 0; i < this.coefficients().length; i++) {
            if (this.coefficient(i) != poly.coefficient(i)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i <= this.degree(); i++) {
            if (i == 0) {
                str.append(this.coefficients()[i]);
                str.append(" + ");
            } else if (i == 1) {
                str.append(this.coefficients()[i]);
                str.append("x");
                str.append(" + ");
            } else if (i == this.degree()) {
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
