package oopexercises.classesandobjects.circle;

public class TestCircle {
    public static void main(String[] args) {
        Circle testCircle = new Circle();
        System.out.println(testCircle);
        System.out.println(testCircle.getArea());
        System.out.println(testCircle.getCircumference());

        Circle testCircle2 = new Circle(1.92);
        System.out.println(testCircle2);
        System.out.println(testCircle2.getArea());
        System.out.println(testCircle2.getCircumference());
    }
}
