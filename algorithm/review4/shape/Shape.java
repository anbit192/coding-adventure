package review4.shape;

public abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    public Shape() {
    }

    protected abstract double getVolume();
    protected abstract double getArea();
    protected abstract double getPerimeter();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
