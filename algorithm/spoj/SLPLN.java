package spoj;

import java.util.Scanner;

public class SLPLN {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfTest = scan.nextInt();

        for (int i = 0; i < numberOfTest; i++) {
            int n = scan.nextInt();
            System.out.println(largestCube(n));
        }
    }

    public static int largestCube(int n) {
        return (int) Math.cbrt(n);
    }
}
