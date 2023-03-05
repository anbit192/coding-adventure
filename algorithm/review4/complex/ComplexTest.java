package review4.complex;

import java.util.Scanner;

public class ComplexTest {

    public static void main(String[] args) {
        Complex[] complexes = input();
        System.out.println(sumOfComplexes(complexes));
        System.out.println(getComplex(1, complexes));
    }

    public static Complex[] input() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Complex[] complexes = new Complex[n];

        for (int i = 0; i < n; i++) {
            float real = scan.nextFloat();
            float imagine = scan.nextFloat();

            complexes[i] = new Complex(real, imagine);
        }

        return complexes;
    }

    public static Complex sumOfComplexes(Complex[] array) {
        Complex newComplex = new Complex();

        for (Complex complex : array) {
            newComplex.add(complex);
        }

        return newComplex;
    }

    public static Complex getComplex(int v, Complex[] array) {
        return array[v];
    }
}
