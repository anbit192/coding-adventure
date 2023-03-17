package adtlist.shape;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        Shape shpere1 = new Sphere("an", 1.92);
        Shape circle1 = new Circle("an192", 19.2);
        Shape rec1 = new Rectangle("anbish", 19, 2);

        shapes.add(shpere1);
        shapes.add(circle1);
        shapes.add(rec1);

        for (int i = 0; i < shapes.size(); i++) {
            System.out.println(shapes.get(i));
        }

    }
}
