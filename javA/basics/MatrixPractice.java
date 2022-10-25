import java.util.Arrays;
import java.util.Scanner;

public class MatrixPractice {


    public static int[][] inputMatrix(Scanner scan){

        System.out.println("Enter the size of matrix n*n");
        int n = scan.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i< n; i++) {
            for (int j = 0; j<n; j++) {

                System.out.printf("Enter the row %S , column %S\n", i, j);
                matrix[i][j] = scan.nextInt();
            }
        }

        return matrix;
    }


    public static boolean isDiagDominant (int[][] matrix) {

        for (int i = 0; i<matrix.length-1; i++) {
            for (int j = i+1; j<matrix[0].length;j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }


    public static int findMax(int[] array) {

        int max = array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }


    public static int[] findColumns(int[][] matrix) {

        int[] minOfColumns = new int[matrix[0].length];
        int maxOfMins ;
        int size=0;
        int count = 0;

        for (int i = 0; i<matrix.length; i++) {

            int minOfCol = Integer.MAX_VALUE;

            for (int j = 0; j<matrix[0].length; j++) {

                if (matrix[j][i] < minOfCol) {

                    minOfCol = matrix[j][i];
                }
            }

            minOfColumns[i] = minOfCol;
        }

        maxOfMins = findMax(minOfColumns);
        System.out.println("mins of columns array: ");
        System.out.println(Arrays.toString(minOfColumns));
        System.out.println("max of mins: ");
        System.out.println(maxOfMins);
        
        for (int i = 0; i<minOfColumns.length; i++) {
            if (minOfColumns[i] == maxOfMins) {
                size++;
            }
        }

        int[] maxOfMinsIndexes = new int[size];

        for (int i = 0; i<minOfColumns.length; i++) {
            if (minOfColumns[i] == maxOfMins) {
                maxOfMinsIndexes[count] = i;
                count++;
            }
        }

        return maxOfMinsIndexes;
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[][] matrix = inputMatrix(scan);

        for (int[] ints : matrix) {

            System.out.println(Arrays.toString(ints));
        }

        System.out.println(isDiagDominant(matrix));
        int[] maxOfMinsIndexes = findColumns(matrix);

        System.out.println("Max Of Mins Indexes :");
        System.out.println(Arrays.toString(maxOfMinsIndexes));
    }
}
