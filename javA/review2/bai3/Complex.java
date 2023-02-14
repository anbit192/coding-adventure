package review2.bai3;

import java.util.Scanner;

public class Complex {
    private double real;
    private double imagine;


    public Complex(double real, double imagine) {
        this.real = real;
        this.imagine = imagine;
    }

    public Complex() {
        this.real = 0;
        this.imagine = 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double real1 = scan.nextDouble();
        double imagine1 = scan.nextDouble();
        double real2 = scan.nextDouble();
        double imagine2 = scan.nextDouble();

        Complex complex1 = new Complex(real1, imagine1);
        Complex complex2 = new Complex(real2, imagine2);

        System.out.println("Complex 1");
        System.out.println(complex1);

        System.out.println("Complex 2");
        System.out.println(complex2);

        System.out.println("Add");
        System.out.println(complex1.add(complex2));

        System.out.println("Multiply");
        System.out.println(complex1.multiply(complex2));
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImagine() {
        return imagine;
    }

    public void setImagine(double imagine) {
        this.imagine = imagine;
    }

    public Complex add(Complex another) {
        double newReal = this.real + another.real;
        double newImagine = this.imagine + another.imagine;
        return new Complex(newReal, newImagine);

    }

    public Complex add(double anotherReal, double anotherImagine) {
        Complex newComplex = new Complex(this.real + anotherReal, this.imagine + anotherImagine);
        return newComplex;
    }

    public Complex multiply(Complex another) {
        double newReal = this.real * another.real - this.imagine * another.imagine;
        double newImagine = this.real * another.imagine + this.imagine * another.real;

        return new Complex(newReal, newImagine);
    }

    @Override
    public String toString() {
        return String.format("%.2f  +  %.2f i", this.real, this.imagine);
    }
}
