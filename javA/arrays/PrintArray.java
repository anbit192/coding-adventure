package arrays;

import java.util.Scanner;

public class PrintArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array =  inputArray(scan);
        printArray(array);

    }

    public static int[] inputArray(Scanner scan) {
        int n = scan.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }

        return array;
    }

    public static void printArray(int[] array) {
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("]");
    }
}
