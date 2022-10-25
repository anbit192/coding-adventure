package oopexercises.inheritance.shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, Boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
        super();
        this.radius = 1.0;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return 2*Math.PI *this.getRadius()*this.getRadius();
    }

    public double getPerimeter() {
        return 2*Math.PI * this.getRadius();
    }

    @Override
    public String toString() {
        return String.format("Circle[%s , radius = %s]", super.toString(), this.getRadius());
    }
}
