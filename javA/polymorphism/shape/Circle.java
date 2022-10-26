package polymorphism.shape;

public class Circle extends Shape {
    protected double radius;

    public Circle() {
        this.radius = 0.0;
    }

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
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
        return String.format("Circle[%s, radius = %.2f]", super.toString(), this.getRadius());
    }
}
