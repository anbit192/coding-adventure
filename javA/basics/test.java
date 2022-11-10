package basics;

public class test {
    public static void main(String[] args) {

        double[] coefficients = {5,10};

        for (double item : coefficients) {
            System.out.print(item + " ");
        }
        System.out.println();

        double[] derivativeCoeffiecient = new double[coefficients.length-1];

        if (coefficients.length == 1) {
            derivativeCoeffiecient[0] = 0;

        }
        else {
            for (int i = 0; i < coefficients.length-1; i++) {

                double derivedCoeff = (i+1) * coefficients[i+1];
                derivativeCoeffiecient[i] = derivedCoeff;
            }
        }

        for (double item : derivativeCoeffiecient) {
            System.out.print(item + " ");
        }
        System.out.println();

    }
}
