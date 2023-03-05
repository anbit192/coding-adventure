package spoj;

import java.util.Scanner;

public class SNTFIBO {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfTest = scan.nextInt();
        for (int i = 0; i < numberOfTest; i++) {
            int n = scan.nextInt();

            if (isFibonacci(n) && isPrime(n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    public static boolean isPerfectSquare(int n) {
        int a = (int) Math.sqrt(n);
        return Math.pow(a, 2) == n;
    }

    public static boolean isFibonacci(int n) {
        // n is Fibonacci if one of 5*n*n + 4 or 5*n*n - 4 or both is a perfect square
        return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
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
}
