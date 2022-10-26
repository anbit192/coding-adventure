package loops;

import java.util.Scanner;

public class BoxPatterns {

    public static void patternA(int size) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (i == 0 || i == size - 1) {
                    System.out.print("# ");
                }

                else if (j == 0 || j == size - 1) {
                    System.out.print("# ");
                }

                else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }

    public static void patternB(int size) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (i == 0 || i == size - 1) {
                    System.out.print("# ");
                }

                else if (j == i) {
                    System.out.print("# ");
                }

                else if (j < i) {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }

    public static void patternC(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (i == 0 || i == size - 1) {
                    System.out.print("# ");
                }

                else if (j == size - i - 1) {
                    System.out.print("# ");
                }

                else if (j < size - i) {
                    System.out.print("  ");
                }

            }

            System.out.println();
        }
    }

    public static void patternD(int size) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (i == 0 || i == size - 1) {
                    System.out.print("# ");
                }

                else if (j == i || j == size - i - 1) {
                    System.out.print("# ");
                }

                else if (j != i || j != size - 1) {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        patternA(size);
        System.out.println();
        patternB(size);

        System.out.println();
        patternC(size);

        System.out.println();
        patternD(size);
    }
}
