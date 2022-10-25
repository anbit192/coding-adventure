package oopexercises.composition.points;

public class TestTriangle {
    public static void main(String[] args) {

        MyPoint v1 = new MyPoint(2,1);
        MyPoint v2 = new MyPoint(7,1);
        MyPoint v3 = new MyPoint(2,-1);
        MyTriangle triangle1 = new MyTriangle(v1,v2,v3);

        System.out.println(triangle1);
        System.out.println(triangle1.getPerimeter());
        System.out.println(triangle1.getType());
    }
}
