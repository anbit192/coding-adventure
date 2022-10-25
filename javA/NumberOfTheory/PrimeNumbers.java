package NumberOfTheory;

import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int upperbound = scan.nextInt();
        primeList(upperbound);
    }

    public static boolean isPrime(int n) {
        if (n == 0) {
            return false;
        }

        for (int i = 2; i < n; i++) {

            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void primeList(int upperbound) {
        int countPrime = 0;
        for (int i = 0; i <= upperbound; i++) {
            if (isPrime(i)) {
                countPrime++;
                System.out.print(i + " ");
            }
        }
        System.out.println();

        System.out.printf("%d prime numbers ( %.2f %% )\n", countPrime, ((countPrime * 1.0) / upperbound) * 100.0);
    }
}
