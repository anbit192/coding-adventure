package oopexercises.collections.polynomials;

import java.util.ArrayList;
import java.util.List;

public class ListPoly extends AbstractPoly {
    List<Double> coefficients;

    public ListPoly(List<Double> coefficients) {
        this.coefficients = coefficients;
    }


    @Override
    public double[] coefficients() {
        double[] arrayCoefficients = new double[this.coefficients.size()];
        for (int i = 0; i < this.coefficients.size(); i++) {
            arrayCoefficients[i] = this.coefficients.get(i);
        }

        return arrayCoefficients;
    }

    @Override
    public double coefficient(int degree) {
        return this.coefficients.get(degree);
    }

    @Override
    public int degree() {
        return this.coefficients.size() - 1;
    }

    @Override
    public Poly derivative() {
        ArrayList<Double> derivativeCoefficients = new ArrayList<>();

        for (double item : this.derive()) {
            derivativeCoefficients.add(item);
        }


        return new ListPoly(derivativeCoefficients);
    }
}

