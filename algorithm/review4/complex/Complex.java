package review4.complex;

public class Complex {
    private float real;
    private float imagine;

    public Complex(float real, float imagine) {
        this.real = real;
        this.imagine = imagine;
    }

    public Complex() {
        this.real = 0.0f;
        this.imagine = 0.0f;
    }

    public static void main(String[] args) {

    }

    public float getReal() {
        return real;
    }

    public void setReal(float real) {
        this.real = real;
    }

    public float getImagine() {
        return imagine;
    }

    public void setImagine(float imagine) {
        this.imagine = imagine;
    }

    public Complex add(Complex another) {
        this.real += another.real;
        this.imagine += another.imagine;

        return this;
    }

    public Complex minus(Complex another) {
        this.real -= another.real;
        this.imagine -= another.imagine;

        return this;
    }

    public Complex time(Complex another) {
        this.real = this.real * another.real - this.imagine * another.imagine;
        this.imagine = this.real * another.imagine + this.imagine * another.real;

        return this;
    }

    @Override
    public String toString() {
        return String.format("%.2f + %.2fi", this.real, this.imagine);
    }


}
