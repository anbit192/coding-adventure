package polymorphism.shape;

public class Square extends Rectangle {
    public Square(double width) {
        super(width, width);
    }

    public Square(String color, boolean filled, double width) {
        super(color, filled, width, width);
    }

    public Square() {
        super();
    }

    public double getSide() {
        return this.width;
    }

    public void setSide(double side) {
        this.setWidth(side);
    }

    public void setWidth(double width) {
        this.setWidth(width);
        this.setLength(width);
    }

    public void setLength(double length) {
        this.setLength(length);
        this.setWidth(length);
    }

    @Override
    public String toString() {
        return String.format("Square[%s]", super.toString());
    }

}
