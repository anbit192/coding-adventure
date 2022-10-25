package oopexercises.composition.points;

public class MyPoint {
    private int x;
    private int y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY() {
        int[] coords = new int[2];
        coords[0] = this.getX();
        coords[1] = this.getY();
        return coords;
    }

    public void setXY(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", this.getX(), this.getY());
    }

    public double distance(int x, int y) {
        return Math.sqrt(Math.pow(this.getX() - x,2) + Math.pow(this.getY()-y,2));
    }

    public double distance(MyPoint other) {
        return Math.sqrt(Math.pow(this.getX() - other.getX(),2) + Math.pow(this.getY() - other.getY(),2));
    }

    public double distance() {
        return Math.sqrt(this.getX() * this.getX() + this.getY() * this.getY());
    }
}
