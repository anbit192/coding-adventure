package NumberOfTheory;

import java.util.Scanner;

public class PrimeFactors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int upperbound = scan.nextInt();
        primeFactorsList(upperbound);


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

    public static boolean isPrimeFactors(int n) {
        int product = 1;
        for (int i = 1; i < n; i++) {
            if (isPrime(i) && n % i == 0) {
                product *= i;
            }
        }

        if (product == n) {
            return true;
        } else {
            return false;
        }
    }

    public static void primeFactorsList(int upperbound) {
        int perfectPrimeCount = 0;
        for (int i = 2; i <= upperbound; i++) {
            if (isPrimeFactors(i)) {
                perfectPrimeCount++;
                System.out.print(i + " ");
            }
        }

        System.out.printf("\n%d perfect prime numbers ( %.2f %% )\n", perfectPrimeCount, ((perfectPrimeCount * 1.0) / upperbound) * 100.0);
    }
}
