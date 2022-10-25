package oopexercises.inheritance.shapes;

public class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
    }

    public Square(String color, Boolean filled, double side) {
        super(color, filled, side, side);
    }

    public Square() {
        super();
    }

    public double getSide() {
        return this.getWidth();
    }

    public void setSide(double side) {
        this.setWidth(side);
        this.setLength(side);
    }

    public void setWidth(double side) {
        this.setWidth(side);
        this.setLength(side);
    }

    public void setLength(double side) {
        this.setLength(side);
        this.setWidth(side);
    }

    public String toString() {
        return String.format("Square[%s, width = %.2f, length = %.2f]",super.toString(), this.getWidth(), this.getLength());
    }
}
