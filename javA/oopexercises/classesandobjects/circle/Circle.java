package oopexercises.classesandobjects.circle;

public class Circle {
    private double radius;

    public Circle() {
        this.radius = 1.0;
        System.out.println("Default constructor.");
    }

    public Circle(double radius) {
        this.radius = radius;
        System.out.println("Parameter Constructor.");
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
        return String.format("Circle[radius = %.2f]",this.getRadius());
    }
}
