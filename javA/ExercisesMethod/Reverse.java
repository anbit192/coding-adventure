package ExercisesMethod;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = array(scan);
        reverse(array);
    }

    public static int[] array(Scanner scan) {
        int n = scan.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }

        return array;
    }

    public static void reverse(int[] array) {
        for (int i = 0; i < array.length/2; i++) {
            int temp = array[i];
            array[i] = array[i+1];
            array[array.length - i -1] = temp;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    
    
}
