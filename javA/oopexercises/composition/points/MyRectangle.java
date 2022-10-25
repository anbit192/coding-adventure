package oopexercises.composition.points;

public class MyRectangle {
    private MyPoint topLeft;
    private MyPoint bottomRight;

    public MyRectangle(MyPoint topLeft, MyPoint bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public MyPoint getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(MyPoint topLeft) {
        this.topLeft = topLeft;
    }

    public MyPoint getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(MyPoint bottomRight) {
        this.bottomRight = bottomRight;
    }

    public MyPoint getBottomLeft() {
        MyPoint bottomLeft = new MyPoint();
        bottomLeft.setXY(this.getTopLeft().getX(), this.getBottomRight().getY());

        return bottomLeft;
    }

    public MyPoint getTopRight() {
        MyPoint topRight = new MyPoint();
        topRight.setXY(this.getBottomRight().getX(), this.getTopLeft().getY());
        return topRight;
    }

    @Override
    public String toString() {
        return String.format("Rectangle[A = %s, B= %s, C = %s, D = %s]", this.getTopLeft().toString(), this.getTopRight().toString(), this.getBottomLeft().toString(), this.getBottomRight().toString());
    }
}
