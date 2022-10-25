package oopexercises.classesandobjects.anothercircle;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle(1.1);
        System.out.println(circle1);

        Circle circle2 = new Circle();
        System.out.println(circle2);

        System.out.println("Set radius of circle 1 to 1.92.");
        circle1.setRadius(1.92);

        System.out.println("Radius of circle 1: "+circle1.getArea());
        System.out.println("Circumference of circle 1: "+ circle1.getCircumference());
    }
}
