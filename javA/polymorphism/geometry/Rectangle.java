package polymorphism.geometry;

public class Rectangle implements GeometricObject {

    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
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
        return 2*(this.getWidth() + this.getLength());
    }

    @Override
    public String toString() {
        return String.format("Rectangle[width = %.2f, length = %.2f]", this.getWidth(), this.getLength());
    }
}
