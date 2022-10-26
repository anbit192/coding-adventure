package numbers;

import java.util.Scanner;

public class PerfectAndDeficientNumbers {
    public static void main(String[] args) {
        System.out.println(isPerfect(6));
        System.out.println(isDeficient(10));

        Scanner scan = new Scanner(System.in);
        int upperbound = scan.nextInt();
        perfectNumberList(upperbound);

    }

    public static boolean isPerfect(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        return n == sum;
    }

    public static boolean isDeficient(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        return sum < n;
    }

    public static void perfectNumberList(int upperbound) {
        int countPerfect = 0;
        int countDeficient = 0;

        System.out.printf("Perfect numbers in range %d:\n", upperbound);
        for (int i = 2; i <= upperbound; i++) {

            if (isPerfect(i)) {
                System.out.print(i + " ");
                countPerfect++;
            } else if (isDeficient(i)) {
                countDeficient++;
            }
        }
        System.out.println();
        System.out.printf("[ %d perfect numbers found ( %.2f %%) ]\n", countPerfect, ((countPerfect * 1.0) / upperbound) * 100.0);

        System.out.println("Normal numbers: ");

        for (int i = 0; i <= upperbound; i++) {
            if (!(isPerfect(i) || isDeficient(i))) {
                System.out.print(i + " ");
            }
        }

        int remainingNumbers = upperbound - countPerfect - countDeficient;
        System.out.println();
        System.out.printf("[ %d numbers are neither deficient nor perfect ( %.2f %%) ]", (remainingNumbers), ((remainingNumbers * 1.0) / upperbound) * 100.0);
    }

}
