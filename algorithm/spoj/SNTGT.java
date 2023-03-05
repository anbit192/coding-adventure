package spoj;

import java.util.Scanner;

public class SNTGT {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfTest = scan.nextInt();


        for (int i = 0; i < numberOfTest; i++) {
            int n = scan.nextInt();
            if (isFactorialPrime(n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    public static boolean isFactorialPrime(int n) {

        if (!isPrime(n)) {
            return false;
        }

        for (int j = 1; j <= n; j++) {
            if (factorial(j) == n || factorial(j) - 1 == n || factorial(j) + 1 == n) {
                return true;
            }
        }

        return false;
    }


    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

}
