package oopexercises.classesandobjects.rectangle;

public class TheRectangle {
    private float length;
    private float width;

    public TheRectangle() {
        this.length = 1.0f;
        this.width = 1.0f;
    }

    public TheRectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public double getArea() {
        return this.getLength() * this.getWidth();
    }

    public double getPerimeter() {
        return (this.getLength() + this.getWidth()) * 2;
    }

    @Override
    public String toString() {
        return String.format("Rectangle[length = %.2f , width = %.2f]",this.getLength(), this.getWidth());
    }
}
