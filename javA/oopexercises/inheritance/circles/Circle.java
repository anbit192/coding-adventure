package oopexercises.inheritance.circles;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        this.radius = 1.0;
        this.color = "Red";
        System.out.println("Default constructor.");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;

        System.out.println("Parameter Constructor.");
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getCircumference() {
        return 2*Math.PI * this.getRadius();
    }

    public double getArea() {
        return Math.PI * Math.pow(this.getRadius(),2);
    }

    @Override
    public String toString() {
        return String.format("Circle[radius = %.2f, color = %s]",this.getRadius(), this.getColor());
    }
}

