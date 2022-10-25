package ExercisesMethod;

import java.util.Scanner;

public class Print {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = inputArray(scan);
        print(array);

    }

    public static int[] inputArray(Scanner scan) {

        int n = scan.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }

        return array;
    }

    public static void print(int[] array) {
        System.out.print("[ ");
        for (int i = 0; i<array.length;i++) {

            if (i == array.length-1) {
                System.out.print(array[i]);
            }
            else {
                System.out.print(array[i] +", ");

            }
        }
        System.out.print(" ]");
        System.out.println();
    }
}
