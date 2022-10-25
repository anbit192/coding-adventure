package oopexercises.inheritance.points;

public class Point2D {
    protected float x;
    protected float y;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        float[] coords = {this.getX(), this.getY()};
        return coords;
    }

    public void setXY(float x , float y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", this.getX(), this.getY());
    }
}
