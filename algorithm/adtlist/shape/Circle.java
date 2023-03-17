package adtlist.shape;

public class Circle extends Shape {

    protected double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public Circle() {
        super();
        this.radius = 0;
    }

    @Override
    protected double getVolume() {
        return 0;
    }

    @Override
    protected double getArea() {
        return this.radius * this.radius * Math.PI;
    }

    @Override
    protected double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return String.format("Circle[name = %s, radius = %.2f]", this.name, this.radius);
    }


}
