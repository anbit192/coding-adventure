package methods;

import java.util.Scanner;

public class GradesStatistics2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = input(sc);
        printArray(array);
        System.out.println("The average is: " + findAverage(array));
        findMedian(array);
        findMin(array);
        findMax(array);
        findStandardDeviation(array);


    }

    public static int[] input(Scanner sc) {
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter the grade for student " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static void printArray(int[] array) {
        System.out.print("The grades are: ");
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("[ " + array[i] + ", ");
            } else if (i > 0 && i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i] + " ]");
            }

        }
        System.out.println(" ");
    }

    public static double findAverage(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];

        }
        //System.out.println("The average is: " + (double) sum / array.length);
        return (double) sum / array.length;
    }

    public static void findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println("The min is: " + min);
    }

    public static void findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println("The max is: " + max);
    }

    public static void findMedian(int[] array) {
        while (true) {
            boolean sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    sorted = false;
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            if (sorted == true) {
                break;
            }

        }
        if (array.length % 2 != 0) {
            System.out.println("The median is: " + array[array.length / 2]);

        } else {
            double med1 = array[(array.length / 2) - 1];
            double med2 = array[array.length / 2];
            double median = (med1 + med2) / 2.0;
            System.out.println("The median is: " + median);

        }
    }

    public static void findStandardDeviation(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += (array[i] - findAverage(array)) * (array[i] + findAverage(array));
        }
        double standardDeviation = Math.sqrt(sum / array.length);
        System.out.println("The Standard Deviation is: " + standardDeviation);
    }
}
