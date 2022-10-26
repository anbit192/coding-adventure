package polymorphism.geometry;

public class Circle implements GeometricObject {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.getRadius(),2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.getRadius();
    }

    @Override
    public String toString() {
        return String.format("Circle[radius = %.2f]", this.getRadius());
    }
}
