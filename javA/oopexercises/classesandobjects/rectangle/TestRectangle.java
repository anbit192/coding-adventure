package oopexercises.classesandobjects.rectangle;

public class TestRectangle {
    public static void main(String[] args) {
        TheRectangle rectangle1 = new TheRectangle(1.2f, 3.4f);
        System.out.println(rectangle1);
        TheRectangle rectangle2 = new TheRectangle();
        System.out.println(rectangle2);

        rectangle1.setLength(5.6f);
        rectangle1.setWidth(7.8f);

        System.out.println(rectangle1);

        System.out.println(rectangle1.getArea());
        System.out.println(rectangle1.getPerimeter());
    }
}
