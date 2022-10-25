package oopexercises.composition.points;

public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.v1.setXY(x1, y1);
        this.v2.setXY(x2, y2);
        this.v3.setXY(x3, y3);

    }

    public MyPoint getV1() {
        return v1;
    }

    public void setV1(MyPoint v1) {
        this.v1 = v1;
    }

    public MyPoint getV2() {
        return v2;
    }

    public void setV2(MyPoint v2) {
        this.v2 = v2;
    }

    public MyPoint getV3() {
        return v3;
    }

    public void setV3(MyPoint v3) {
        this.v3 = v3;
    }

    public String toString() {
        return String.format("MyTriangle[v1=%s, v2=%s, v3=%s]", this.getV1(), this.getV2(), this.getV3());
    }

    public double getPerimeter() {
        MyLine line1 = new MyLine(this.v1, this.v2);
        MyLine line2 = new MyLine(this.v1, this.v3);
        MyLine line3 = new MyLine(this.v2, this.v3);

        return line1.getLength() + line2.getLength() + line3.getLength();
    }

    public String getType() {
        MyLine line1 = new MyLine(this.v1, this.v2);
        MyLine line2 = new MyLine(this.v1, this.v3);
        MyLine line3 = new MyLine(this.v2, this.v3);

        if (line1.getLength() == line2.getLength() && line1.getLength() == line3.getLength()) {
            return "Equilateral";
        }
        else if (line1.getLength() == line2.getLength() || line1.getLength() == line3.getLength() || line2.getLength() == line3.getLength()) {
            return "Isosceles";
        }
        else {
            return "Scalene";
        }


    }
}
