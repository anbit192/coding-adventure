package oopexercises.composition.points;

public class TestLine {
    public static void main(String[] args) {
        MyPoint a = new MyPoint(1,3);
        MyPoint b = new MyPoint(3,9);

        MyLine ab = new MyLine(a,b);

        System.out.println(ab);

        System.out.println(ab.getLength());
        System.out.println(ab.getGradient());
        System.out.println(ab.getEnd());
        ab.setEndXY(5,5);
        System.out.println(ab);
    }
}
