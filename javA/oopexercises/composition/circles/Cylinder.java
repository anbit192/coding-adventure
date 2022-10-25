package oopexercises.composition.circles;

public class Cylinder {
    private Circle baseCircle;
    private double height;

    public Cylinder(Circle baseCircle, double height) {
        this.baseCircle = baseCircle;
        this.height = height;
    }

    public Cylinder() {
        this.baseCircle = new Circle();
        this.height = 1.0;
    }

    public Circle getBaseCircle() {
        return baseCircle;
    }

    public void setBaseCircle(Circle baseCircle) {
        this.baseCircle = baseCircle;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return (2*this.getBaseCircle().getArea() + this.getBaseCircle().getCircumference()*this.getHeight());
    }

    public double getVolume() {
        return this.getBaseCircle().getArea()*this.getHeight();
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "baseCircle=" + baseCircle +
                ", height=" + height +
                '}';
    }
}
