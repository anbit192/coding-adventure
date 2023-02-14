package review2.bai2;

import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
        int[] array = inputArray();
        print(array);
        sort(array);
        print(array);
        search(array, 2);


    }

    public static int[] inputArray() {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }

        scan.close();
        return array;
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] > array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static int search(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public static void print(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }

        System.out.println();
    }


}
