package ExercisesNestedLoops;

import java.util.Scanner;

public class TriangularPatterns {

    public static void patternA(int area) {

        for (int i = 0; i < area; i++) {
            for (int j = 0 ; j < area; j++) {

                if (j <= i) {
                    System.out.print("# ");
                }
            }

            System.out.println();
        }
    }

    public static void patternB(int area) {
        for (int i = 0; i < area; i++) {
            for (int j = 0; j < area; j++) {

                if (j < area - i) {

                    System.out.print("# ");
                }
            }

            System.out.println();
        }
    }

    public static void patternC(int area) {
        for (int i = 0; i < area; i++) {
            for (int j = 0; j < area; j++) {
                if (j >= i) {
                    System.out.print("# ");

                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }


    public static void patternD(int area) {

        for (int i = 0; i <= area; i++) {
            for (int j = 0; j < area; j++) {

                if (j >= area - i) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int area = scan.nextInt();

        patternA(area);
        System.out.println();

        patternB(area);
        System.out.println();

        patternC(area);
        System.out.println();

        patternD(area);


    }
}