package oopexercises.composition.points;

public class TestRectangle {
    public static void main(String[] args) {
        MyPoint bottomRight = new MyPoint(4,1);
        MyPoint topLeft = new MyPoint(1,4);

        MyRectangle rectangle1 = new MyRectangle(topLeft, bottomRight);

        System.out.println(rectangle1);
    }
}
