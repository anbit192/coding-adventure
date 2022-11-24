package oop.poly;

import java.util.ArrayList;
import java.util.List;

public class ListPoly extends AbstractPoly {
    private List<Integer> coefficients;

    public ListPoly(int[] coefficients) {
        this.coefficients = new ArrayList<>();
        for (int coefficient : coefficients) {
            this.coefficients.add(coefficient);
        }

    }

    private static int[] convertToArray(ArrayList<Integer> list) {
        int[] newArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            newArray[i] = list.get(i);
        }

        return newArray;
    }

    @Override
    public int coefficient(int degree) {
        return this.coefficients.get(degree);
    }

    @Override
    public int[] coefficients() {
        int[] arrayPoly = new int[this.coefficients.size()];

        for (int i = 0; i < arrayPoly.length; i++) {
            arrayPoly[i] = this.coefficients.get(i);
        }
        return arrayPoly;
    }

    @Override
    public Poly derivative() {
        return new ListPoly(differentiate());
    }

    @Override
    public double evaluate(double x) {
        double sum = 0;
        for (int i = this.degree(); i >= 0; i--) {
            sum = sum * x + this.coefficient(i);
        }
        return sum;
    }

    private void reduce() {
        while (this.coefficient(this.degree()) == 0) {
            this.coefficients.remove(this.degree());
        }
    }

    public ListPoly plus(ListPoly anotherPoly) {
        int maxDegree = Math.max(this.degree(), anotherPoly.degree());
        ArrayList<Integer> sumCoefficients = new ArrayList<>();
        for (int i = 0; i <= maxDegree; i++) {
            sumCoefficients.add(0);
        }

        for (int i = 0; i <= this.degree(); i++) {
            int coeff = this.coefficient(i) + sumCoefficients.get(i);
            sumCoefficients.set(i, coeff);
        }

        for (int i = 0; i <= anotherPoly.degree(); i++) {
            int coeff = this.coefficient(i) + sumCoefficients.get(i);
            sumCoefficients.set(i, coeff);
        }

        return new ListPoly(convertToArray(sumCoefficients));

    }

    public ListPoly minus(ListPoly anotherPoly) {
        ArrayList<Integer> subtractCoefficients = new ArrayList<>();
        int maxDegree = Math.max(this.degree(), anotherPoly.degree());

        for (int i = 0; i <= maxDegree; i++) {
            subtractCoefficients.add(0);
        }


        for (int i = 0; i <= this.degree(); i++) {
            int coeff = this.coefficient(i) - subtractCoefficients.get(i);
            subtractCoefficients.set(i, coeff);
        }

        for (int i = 0; i <= anotherPoly.degree(); i++) {
            int coeff = anotherPoly.coefficient(i) - subtractCoefficients.get(i);
            subtractCoefficients.set(i, coeff);
        }

        return new ListPoly(convertToArray(subtractCoefficients));
    }

    public ListPoly times(ListPoly anotherPoly) {
        ArrayList<Integer> multiplyCoefficients = new ArrayList<>();

        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= anotherPoly.degree(); j++) {
                multiplyCoefficients.set(i+j, this.coefficient(i) * anotherPoly.coefficient(j));
            }
        }

        return new ListPoly(convertToArray(multiplyCoefficients));
        
    }

    public String type() {
        return this.getClass().getName();
    }
}
