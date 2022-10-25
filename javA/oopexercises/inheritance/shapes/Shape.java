package oopexercises.inheritance.shapes;

public class Shape {
    private String color;
    private Boolean filled;

    public Shape(String color, Boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public Shape() {

        this.color = "red";
        this.filled = true;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean isFilled() {
        return filled;
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    public double getArea() {
        return 0.0;
    }

    public double getPerimeter() {
        return 0.0;
    }

    @Override
    public String toString() {
        return String.format("Shape[color = %s, filled = %s]", this.getColor(), this.isFilled().toString());
    }
}
