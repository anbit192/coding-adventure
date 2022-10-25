package ExercisesMethod;

import java.util.Scanner;

public class Contains {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = scan.nextInt();
        int[] array = array(scan);
        System.out.println(contains(array, number));

    }

    public static int[] array(Scanner scan) {
        int n = scan.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }

        return array;
    }

    public static boolean contains(int[] array, int number) {
        for (int item : array) {
            if (item == number) {
                return true;

            }
        }

        return false;
    }
}
