package oopexercises.composition.points;

public class TestMyCircle {
    public static void main(String[] args) {
        MyPoint o1 = new MyPoint(1,3);
        MyCircle circle1 = new MyCircle(o1, 2);
        System.out.println(circle1);
        System.out.println(circle1.getCenterX());
        System.out.println(circle1.getCenterY());


        MyPoint o2 = new MyPoint(4,3);
        MyCircle circle2 = new MyCircle(o2, 4);
        System.out.println(circle2);

        System.out.println(circle1.distance(circle2));

        System.out.println(circle1.getArea());
        System.out.println(circle1.getCircumference());
    }
}

