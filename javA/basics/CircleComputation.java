import java.util.Scanner;

public class CircleComputation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Double radius = scan.nextDouble();
        Double diameter = 2*radius;
        Double area = Math.PI * Math.pow(radius,2);
        Double circumference = Math.PI * 2 * radius;

        System.out.println(diameter);
        System.out.println(area);
        System.out.println(circumference);
    }
}
