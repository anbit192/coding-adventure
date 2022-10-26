package loops;

import java.util.Scanner;

public class HillPatterns {

    public static void patternA(int rows, int columns) {

        int middleIndex = ((columns) / 2); // 0 1 2 3 4 5 6 => middle INDEX = 4 (middle value = 3)

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {

                if ((col >= middleIndex - row) && (col <= middleIndex + row)) {
                    System.out.print("* ");
                } else if ((col < middleIndex - row) || (col > middleIndex + row)) {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }

    }

    public static void patternB(int rows, int columns) {

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {

                if (col >= row && col <= columns - row - 1) {

                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }

    public static void patternC(int rows, int columns) {

        for (int row = 0; row < (rows * 2) - 1; row++) {
            for (int col = 0; col < columns; col++) {

                int middleIndex = (columns / 2);

                if (row <= middleIndex) {
                    if ((col >= middleIndex - row) && (col <= middleIndex + row)) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                } else {
                    if ((col >= (row - middleIndex)) && (col <= (columns - row + middleIndex - 1))) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }

            System.out.println();
        }
    }

    public static void patternD(int rows, int columns) {

        for (int row = 0; row < (rows * 2) - 1; row++) {
            for (int col = 0; col < columns; col++) {

                int middleIndex = (columns / 2);

                if (row <= middleIndex) {
                    if ((col > middleIndex - row) && (col < middleIndex + row)) {
                        System.out.print("  ");
                    } else {
                        System.out.print("* ");
                    }
                } else {
                    if ((col > (row - middleIndex)) && (col < (columns - row + middleIndex - 1))) {
                        System.out.print("  ");
                    } else {
                        System.out.print("* ");
                    }
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int columns = (rows * 2) - 1;

        patternA(rows, columns);
        System.out.println();
        patternB(rows, columns);
        System.out.println();
        patternC(rows, columns);
        System.out.println();
        patternD(rows, columns);

    }
}
