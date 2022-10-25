package oopexercises.composition.circles;

public class TestCylinder {
    public static void main(String[] args) {
        Circle baseCircle = new Circle(2.0);
        Cylinder cyl1 = new Cylinder(baseCircle,1.92);

        System.out.println(cyl1);
        System.out.println(cyl1.getArea());
        System.out.println(cyl1.getBaseCircle());
        System.out.println(cyl1.getVolume());
    }
}
