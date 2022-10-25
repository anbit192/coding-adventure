package oopexercises.composition.points;

public class MyCircle {
    private MyPoint center;
    private int radius;

    public MyCircle() {
        this.center.setXY(0, 0);
        this.radius = 1;
    }

    public MyCircle(MyPoint center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public MyCircle(int x, int y, int radius) {
        this.center.setXY(x, y);
        this.radius = radius;
    }

    public MyPoint getCenter() {
        return center;
    }

    public void setCenter(MyPoint center) {
        this.center = center;
    }

    public int getCenterX() {
        return this.center.getX();
    }

    public void setCenterX(int x) {
        this.center.setX(x);
    }

    public int getCenterY() {
        return this.center.getY();
    }

    public void setCenterY(int y) {
        this.center.setY(y);
    }

    public int[] getCenterXY() {
        int[] coords = {this.center.getX(), this.center.getY()};
        return coords;
    }

    public void setCenterXY(int x , int y) {
        this.center.setXY(x,y);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return String.format("MyCircle[ radius = %d, center = %s ]", this.getRadius(), this.getCenter().toString());
    }

    public double getArea() {
        return Math.PI * Math.pow(this.getRadius(),2);
    }

    public double getCircumference() {
        return 2*Math.PI*this.getRadius();
    }

    public double distance(MyCircle other) {
        return this.getCenter().distance(other.getCenter());
    }
}
