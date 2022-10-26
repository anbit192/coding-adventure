package polymorphism.resizable;

public class ResizableCircle extends Circle implements Resizable {
    public ResizableCircle(double radius) {
        super(radius);
    }

    public String toString() {
        return String.format("Circle[radius = %.2f]", this.getRadius());
    }

    @Override
    public void resize(int percent) {
        this.setRadius(this.getRadius() * percent / 100.0);
    }
}
