package oopexercises.inheritance.shapes;

public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle(String color, Boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length) {
        super();
        this.width = width;
        this.length = length;
    }

    public Rectangle() {
        super();
        this.width = 1.0;
        this.length = 1.0;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return this.getWidth() * this.getLength();
    }

    @Override
    public double getPerimeter() {
        return 2 * (this.getWidth() + this.getLength());
    }

    public String toString() {
        return String.format("Rectangle[%s, width = %.2f, length = %.2f]", super.toString(), this.getWidth(), this.getLength());
    }
}


