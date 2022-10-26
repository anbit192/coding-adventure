package methods;

import java.util.Scanner;

public class Equals {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array1 = inputArray(scan);
        int[] array2 = inputArray(scan);
        System.out.println(isEqual(array1,array2));
    }

    public static int[] inputArray(Scanner scan) {
        int n = scan.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }

        return array;
    }

    public static boolean isEqual(int[] array1, int[] array2) {

        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    return false;
                }
            }

            return true;

        } else {
            return false;
        }
    }
}
