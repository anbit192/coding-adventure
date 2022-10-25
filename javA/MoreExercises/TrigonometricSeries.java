package MoreExercises;

import java.util.Scanner;

public class TrigonometricSeries {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double radian = scan.nextDouble();
        int numberOfTerms = scan.nextInt();
        System.out.println("Sin value calculated using Math.sin(): ");

        System.out.println(Math.sin(radian));
        double sinValue = sin(radian, numberOfTerms);
        System.out.println("Sin value calculated using for loops: ");
        System.out.println(sinValue);

        System.out.println("==================================");
        System.out.println("Cos value calculated using Math.cos(): ");
        System.out.println(Math.cos(radian));

        System.out.println("Cos value calculated using for loops: ");
        double cosValue = cos(radian,numberOfTerms);
        System.out.println(cosValue);


    }

    public static double sin(double radian, int numberOfTerms) {
        double sum = 0;
        double term;

        for (int i = 1; i < numberOfTerms *2; i += 2) {

            term = 1;
            for (int j = 1; j <= i; j++) {
                term *= radian / j;
            }

            if (i % 4 == 1) {
                sum += term;
            } else {
                sum -= term;
            }
        }

        return sum;
    }
    
    public static double cos(double radian, int numberOfTerms) {
        double sum = 0;
        double term;

        for (int i = 0; i < numberOfTerms*2; i+=2) {

            term = 1;
            for (int j = 1; j <= i ; j++) {
                term *= radian / (double) j;
            }

            if (i%4 == 2) {
                sum -= term;
            }
            else {
                sum += term;
            }
        }

        return sum;
    }
}
