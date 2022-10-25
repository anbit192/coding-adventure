package oopexercises.inheritance.shapes;

public class TestShape {
    public static void main(String[] args) {
        Shape shape1 = new Rectangle(1.5,1.92);
        Shape shape2 = new Square(19.2);
        Shape shape3 = new Circle("red", false, 1.92);

        System.out.println(shape1);
        System.out.println(shape2);
        System.out.println(shape3);

        System.out.println(shape1.getArea());
        System.out.println(shape2.getArea());
        System.out.println(shape3.getArea());
    }
}
