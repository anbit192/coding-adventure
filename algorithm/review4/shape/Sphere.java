package review4.shape;

public class Sphere extends Circle {

    public Sphere(String name, double radius) {
        super(name, radius);
    }

    @Override
    protected double getVolume() {
        return Math.pow(this.radius, 3) * Math.PI * 4/3;
    }

    @Override
    protected double getArea() {
        return 4 * Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    protected double getPerimeter() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Sphere[name = %s, radius = %.2f]", this.name, this.radius);
    }
}
