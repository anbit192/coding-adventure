package methods;

import java.util.Scanner;

public class ArrayToString {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = inputArray(scan);
        System.out.println(arrayToString(array));


    }

    public static int[] inputArray(Scanner scan) {

        int n = scan.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }

        return array;
    }

    public static String arrayToString(int[] array) {

        String arrayString = "[ ";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length-1) {
                arrayString += (array[i] + " ]" );
            }
            else {
                arrayString += (array[i] + ", ");

            }
        }

        return arrayString;
    }

}
