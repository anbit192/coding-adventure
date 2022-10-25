package oopexercises.composition.circles;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        this.radius = 1.0;
        this.color = "red";
        System.out.println("Default constructor called.");
    }

    public Circle(double radius) {
        this.radius = radius;
        System.out.println("Radius constructor called.");
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
        System.out.println("Radius and color constructor called.");
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.getRadius(), 2);
    }

    public double getCircumference() {
        return 2*Math.PI * this.getRadius();
    }

    @Override
    public String toString() {
        return String.format("Circle[radius = %.2f, color = %s]", this.getRadius(), this.getColor());
    }
}
