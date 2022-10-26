package polymorphism.resizable;

public class TestResizableCircle {
    public static void main(String[] args) {
        Circle c1 = new ResizableCircle(1.92);

        System.out.println(c1);
        if (c1 instanceof ResizableCircle) {
            ((ResizableCircle) c1).resize(10);
        }

        System.out.println(c1);
    }
}
