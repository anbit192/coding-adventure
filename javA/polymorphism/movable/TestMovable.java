package polymorphism.movable;

public class TestMovable {
    public static void main(String[] args) {
        Movable m1 = new MovablePoint(5, 6, 10, 15);
        System.out.println(m1);
        m1.moveLeft();
        System.out.println(m1);

        Movable m2 = new MovableCircle(1, 2, 3, 4, 20);
        System.out.println(m2);
        m2.moveRight();
        System.out.println(m2);

        MovablePoint p1 = new MovablePoint(1, 2, 3, 4);
        System.out.println(p1);
        //(1,2)
        p1.moveDown();
        System.out.println(p1);
        //(1,3)
        p1.moveRight();
        System.out.println(p1);
        //(2,3)

        // Test Polymorphism
        Movable p2 = new MovablePoint(3, 4, 5, 6);  // upcast
        p2.moveUp();
        System.out.println(p2);
        //(3,3)

        MovablePoint p3 = (MovablePoint) p2;   // downcast
        System.out.println(p3);
        //(3,3)

        MovableRectangle rec = new MovableRectangle(1,1,3,3,1,1);
        rec.moveUp();
        System.out.println(rec);
        rec.moveDown();
        System.out.println(rec);
        rec.moveLeft();
        System.out.println(rec);
        rec.moveRight();
        System.out.println(rec);
    }
}
