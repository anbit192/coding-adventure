package basics;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class test {
    public static void main(String[] args) {

        double[] derivativeCoeffiecient = new double[coefficients().length-1];
        for (int i = 1; i < this.coefficients().length; i++) {
            double derivedCoeff = i * this.coefficient(i);
            derivativeCoeffiecient[i] = derivedCoeff;
        }
    }
}
