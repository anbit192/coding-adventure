package ExercisesMethod;

import java.util.Scanner;

public class CopyOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = array(scan);
        int[] newArray = cloneArray(array);
    }

    public static int[] array(Scanner scan) {
        int n = scan.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }

        return array;
    }

    public static int[] cloneArray(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }

        return newArray;
    }
}
