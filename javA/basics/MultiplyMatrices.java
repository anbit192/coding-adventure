import java.util.Scanner;

public class MultiplyMatrices {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int m = scan.nextInt();
        int n = scan.nextInt();

        int[][] matrixA = new int[m][n];
        int[][] matrixB = new int[n][m];

        generateMatrices(matrixA, matrixB);
        printMatrix(matrixA);
        printMatrix(matrixB);
        int[][] matrixC = matrixC(matrixA, matrixB);
        printMatrix(matrixC);


    }

    public static void generateMatrices(int[][] matrixA, int[][] matrixB) {
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                matrixA[i][j] = (int) (Math.random() * 10);
            }
        }
        for (int i = 0; i < matrixB.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                matrixB[i][j] = (int) (Math.random() * 10);
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + " ");
            }

            System.out.println("");
        }
    }

    public static int[][] matrixC(int[][] matrixA, int[][] matrixB) {

        int rows = matrixA.length;
        int columns = matrixB[0].length;

        int[][] matrixC = new int[rows][columns];
        int sum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j<columns; j++) {

                for (int k = 0; k<matrixA[0].length;k++) {

                    sum += matrixA[i][k] * matrixB[k][j];
                }

                matrixC[i][j] = sum;
                sum=0;
            }

        }

        return matrixC;
    }
}
