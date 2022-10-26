package methods;

import java.util.Scanner;

public class Exponent {

    public static int exponent(int base, int exponent) {
        int result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int base = scan.nextInt();
        int exponent = scan.nextInt();

        System.out.println(exponent(base, exponent));
    }
}
