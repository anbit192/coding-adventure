package oopexercises.collections.polynomials;

public class ArrayPoly extends AbstractPoly {

    @Override
    public double[] coefficients() {
        return new double[0];
    }

    @Override
    public double coefficient(int degree) {
        return 0;
    }

    @Override
    public int degree() {
        return 0;
    }

    @Override
    public Poly derivative() {
        return null;
    }
}
