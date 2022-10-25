package oopexercises.inheritance.circles;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        super(1.0, "White");
        this.height = 2.0;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return 2*super.getArea() + this.getCircumference()*this.getHeight();
    }

    public double getVolume() {
        return super.getArea() * this.getHeight();
    }
}
