package adtlist.shape;

public class Rectangle extends Shape {

    protected double width;
    protected double length;

    public Rectangle(String name, double width, double length) {
        super(name);
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    protected double getVolume() {
        return 0;
    }

    @Override
    protected double getArea() {
        return this.width * this.length;
    }

    @Override
    protected double getPerimeter() {
        return 2*(this.width+this.length);
    }

    @Override
    public String toString() {
        return String.format("Rectangle[name = %s, width = %.2f, length = %.2f]", this.name, this.width, this.length);
    }
}
