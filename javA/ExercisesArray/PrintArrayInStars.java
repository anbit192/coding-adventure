package ExercisesArray;

import java.util.Scanner;

public class PrintArrayInStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = inputArray(scan);
        printStars(array);

    }

    public static void printStars(int[] array) {

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i]; j++) {

                System.out.print("* ");
            }
            System.out.printf("( %d )", array[i]);
            System.out.println();
        }
    }

    public static int[] inputArray(Scanner scan) {
        int n = scan.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }

        return array;
    }
}
