package spoj;

import java.util.Arrays;
import java.util.Scanner;

public class ACM {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numberOfTest = scan.nextInt();

        for (int i = 0; i < numberOfTest; i++) {
            int numberOfMember = scan.nextInt();

            int[] weights = new int[numberOfMember];
            for (int j = 0; j < numberOfMember; j++) {
                weights[j] = scan.nextInt();
            }

            int[] sums = findSumsOfThree(weights);
            int limit = scan.nextInt();

            System.out.println(findMax(sums, limit));

        }
    }

    public static void print(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static int[] findSumsOfThree(int[] array) {
        int[] sums = new int[combine(array.length, 3)];
        int count = 0;
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    sums[count] = array[i] + array[j] + array[k];
                    count++;
                }
            }
        }
        Arrays.sort(sums);

        return sums;
    }

    public static int findMax(int[] array, int limit) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] < limit) {
                return array[i];
            }
        }

        return -1;
    }

    public static int factorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public static int combine(int n, int k) {
        return (factorial(n) / factorial(k) * factorial(n - k));

    }
}
