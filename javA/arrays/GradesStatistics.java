package arrays;

import java.util.Scanner;

public class GradesStatistics {


    public static int[] inputGrades(Scanner scan, int studentNumber) {

        int[] grades = new int[studentNumber];

        for (int i = 0; i < grades.length; i++) {
            grades[i] = scan.nextInt();
        }

        return grades;
    }

    public static void printArray(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void findAvg(int[] grades) {

        int sum = 0;
        double avg;

        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }

        avg = (double) sum / (double) grades.length;

        System.out.printf("average: %.2f", (avg));
        System.out.println();
    }

    public static void findMin(int[] grades) {

        int min = grades[0];

        for (int grade : grades) {
            if (grade <= min) {
                min = grade;
            }
        }

        System.out.println("basics.test");
        System.out.println("min: " + min);
    }

    public static void findMax(int[] grades) {

        int max = grades[0];

        for (int grade : grades) {
            if (grade >= max) {
                max = grade;
            }
        }

        System.out.println("max: " + max);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int studentNumber = scan.nextInt();

        int[] grades = inputGrades(scan, studentNumber);
        printArray(grades);

        findAvg(grades);
        findMin(grades);
        findMax(grades);

    }
}
