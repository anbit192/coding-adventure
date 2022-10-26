package polymorphism.geometry;

public class TestGeometry {

    public static void main(String[] args) {
        GeometricObject obj1 = new Circle(1.92);
        Rectangle obj2 = new Rectangle(1.92, 19.2);


        System.out.println(obj1.getArea());
        System.out.println(obj2.getWidth());
    }

}
