package oopexercises.classesandobjects.mycomplex;

public class MyComplex {
    private double real;
    private double imagi;

    public MyComplex(double real, double imagi) {
        this.real = real;
        this.imagi = imagi;
    }

    public MyComplex() {
        this.real = 0.0;
        this.imagi = 0.0;
    }

    public double getReal() {
        return real;
    }

    public double getImagi() {
        return imagi;
    }

    public void setImagi(double imagi) {
        this.imagi = imagi;
    }

    public void setValue(double real, double imagi) {
        this.real = real;
        this.imagi = imagi;
    }

    public boolean isReal() {
        if (Double.compare(this.getImagi(), 0.0) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setReal(double real) {
        this.real = real;
    }

    public boolean isImaginary() {
        if (Double.compare(this.getReal(), 0.0) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(double real, double imagi) {
        if (Double.compare(this.getReal(), real) == 0 && Double.compare(this.getImagi(), imagi) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(MyComplex anotherComplex) {
        if (Double.compare(this.getReal(), anotherComplex.getReal()) == 0 && Double.compare(this.getImagi(), anotherComplex.getImagi()) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public double magnitude() {
        return (Math.sqrt(Math.pow(this.getReal(),2) + Math.pow(this.getImagi(),2)));
    }

    public MyComplex addInto(MyComplex another) {
        this.setReal(this.getReal() + another.getReal());
        this.setImagi(this.getImagi() + another.getImagi());

        return this;
    }

    public MyComplex addNew(MyComplex another) {
        MyComplex newComplex = new MyComplex();

        newComplex.setReal(this.getReal() + another.getReal());
        newComplex.setImagi(this.getImagi() + another.getImagi());

        return newComplex;
    }

    @Override
    public String toString() {
        return String.format("%f + %fi", this.getReal(),this.getImagi());
    }
}
