package oopexercises.classesandobjects.polynomial;

public class MyPolynomial {
    double[] coEfficients;

    public MyPolynomial(double... coEfficients) {
        this.coEfficients = coEfficients;
    }

    public double[] getCoEfficients() {
        return coEfficients;
    }

    public void setCoEfficients(double[] coEfficients) {
        this.coEfficients = coEfficients;
    }

    public int getDegree() {
        return this.getCoEfficients().length - 1; //degree 3 => x^0 x^1 x^2 x^3 => length = degree + 1
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        for (int i = this.getDegree(); i >= 0; i--) {
            str.append(this.getCoEfficients()[i]);
            str.append("x^");
            str.append(i);
            str.append("+ ");
        }

        str.delete(str.length() - 2, str.length());

        return str.toString();
    }

    public double evaluate(double x) {
        double sum = 0;
        for (int i = this.getDegree(); i >= 0; i--) {
            sum = sum * x + this.getCoEfficients()[i];
        }

        return sum;
    }

    public MyPolynomial add(MyPolynomial another) {
        int maxDegree = Math.max(this.getDegree() , another.getDegree());
        double[] addedPolynomialData = new double[maxDegree+1];// degree = 3 => x^0 x^1 x^2 x^3 => length = degree + 1

        for (int i = 0; i <= this.getDegree(); i++) {
            addedPolynomialData[i] += this.getCoEfficients()[i];
        }

        for (int i = 0; i <= another.getDegree(); i++) {
            addedPolynomialData[i] += another.getCoEfficients()[i];
        }

        MyPolynomial addedPolynomial = new MyPolynomial(addedPolynomialData);
        return addedPolynomial;
    }

    public MyPolynomial multiply(MyPolynomial another) {
        int multiplyDegree = this.getDegree() + another.getDegree();
        double[] productPolynomialData = new double[multiplyDegree + 1]; //degree 3 => x^0 x^1 x^2 x^3 => length = degree + 1

        for (int i = 0; i <= this.getDegree(); i++) {
            for (int j = 0; j <= another.getDegree(); j++) {
                productPolynomialData[i + j] += this.getCoEfficients()[i] * another.getCoEfficients()[j];
            }
        }

        MyPolynomial productPolynomial = new MyPolynomial(productPolynomialData);
        return productPolynomial;
    }
}
