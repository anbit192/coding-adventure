package methods;

import java.util.Scanner;

public class Swap {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array1 = inputArray(scan);
        int[] array2 = inputArray(scan);
        System.out.println(swap(array1, array2));
    }

    public static int[] inputArray(Scanner scan) {
        int n = scan.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }

        return array;
    }

    public static boolean swap(int[] array1, int[] array2) {

        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                int temp = array1[i];
                array1[i] = array2[i];
                array2[i] = temp;
            }

            return true;
        } else {
            return false;
        }
    }
}
