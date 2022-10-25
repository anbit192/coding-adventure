package oopexercises.composition.points;

public class MyLine {
    private MyPoint begin;
    private MyPoint end;

    //constructors
    public MyLine(MyPoint begin, MyPoint end) {
        this.begin = begin;
        this.end = end;
    }

    public MyLine(int x1, int y1, int x2, int y2) {
        this.begin.setXY(x1, y1);
        this.end.setXY(x2, y2);
    }

    // Getters and setters of begin point.
    public MyPoint getBegin() {
        return begin;
    }

    public void setBegin(MyPoint begin) {
        this.begin = begin;
    }

    public int getBeginX() {
        return this.begin.getX();
    }

    public void setBeginX(int x) {
        this.begin.setX(x);
    }

    public int getBeginY() {
        return this.begin.getY();
    }

    public void setBeginY(int y) {
        this.begin.setY(y);
    }

    public int[] getBeginXY() {
        int[] coords = new int[2];
        coords[0] = this.begin.getX();
        coords[1] = this.begin.getY();

        return coords;
    }

    public void setBeginXY(int x, int y) {
        this.begin.setXY(x, y);
    }

    //Getters and setters of end point.
    public MyPoint getEnd() {
        return end;
    }

    public void setEnd(MyPoint end) {
        this.end = end;
    }

    public int getEndX() {
        return this.end.getX();
    }

    public void setEndX(int x) {
        this.end.setX(x);
    }

    public int getEndY() {
        return this.end.getY();
    }

    public void setEndY(int y) {
        this.end.setY(y);
    }

    public int[] getEndXY() {
        int[] coords = {this.end.getX(), this.end.getY()};
        return coords;
    }

    public void setEndXY(int x, int y) {
        this.end.setXY(x, y);
    }

    public double getLength() {
        return this.getBegin().distance(this.getEnd());
    }

    public double getGradient() {
        int deltaX = Math.abs(this.getBeginX() - this.getEndX());
        int deltaY = Math.abs(this.getBeginY() - this.getEndY());

        return Math.atan2(deltaY, deltaX);
    }

    @Override
    public String toString() {
        return String.format("MyLine[begin = %s, end = %s]", this.getBegin().toString(), this.getEnd().toString());
    }


}
