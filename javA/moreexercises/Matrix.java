package moreexercises;

public class Matrix {

    public static void createRandomMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
    }

    public static int[][] createRandomMatrix(int rows, int columns) {

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }

        return matrix;
    }


    public static void createRandomMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Math.round(Math.random() * 10.0 * 100.0) / 100.0;
            }
        }
    }

    public static double[][] createRandomMatrix(double rows, double columns) {

        double[][] matrix = new double[(int) rows][(int) columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Math.random() * 10;
            }
        }

        return matrix;
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static boolean haveSameDimension(int[][] matrixA, int[][] matrixB) {
        return matrixA.length == matrixB.length && matrixA[0].length == matrixB[0].length;
    }


    public static boolean haveSameDimension(double[][] matrixA, double[][] matrixB) {
        return matrixA.length == matrixB.length && matrixA[0].length == matrixB[0].length;
    }

    public static int[][] add(int[][] matrixA, int[][] matrixB) {
        int[][] matrixC = new int[matrixA.length][matrixA[0].length];

        if (haveSameDimension(matrixA, matrixB)) {
            for (int i = 0; i < matrixA.length; i++) {
                for (int j = 0; j < matrixA[0].length; j++) {
                    matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }

            return matrixC;
        } else {
            return null;
        }

    }

    public static double[][] add(double[][] matrixA, double[][] matrixB) {
        double[][] matrixC = new double[matrixA.length][matrixA[0].length];

        if (haveSameDimension(matrixA, matrixB)) {
            for (int i = 0; i < matrixA.length; i++) {
                for (int j = 0; j < matrixA[0].length; j++) {
                    matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }

            return matrixC;
        } else {
            return null;
        }

    }


    public static int[][] subtract(int[][] matrixA, int[][] matrixB) {
        int[][] matrixC = new int[matrixA.length][matrixA[0].length];

        if (haveSameDimension(matrixA, matrixB)) {
            for (int i = 0; i < matrixA.length; i++) {
                for (int j = 0; j < matrixA[0].length; j++) {
                    matrixC[i][j] = matrixA[i][j] - matrixB[i][j];
                }
            }

            return matrixC;
        } else {
            return null;
        }
    }


    public static double[][] subtract(double[][] matrixA, double[][] matrixB) {
        double[][] matrixC = new double[matrixA.length][matrixA[0].length];

        if (haveSameDimension(matrixA, matrixB)) {
            for (int i = 0; i < matrixA.length; i++) {
                for (int j = 0; j < matrixA[0].length; j++) {
                    matrixC[i][j] = matrixA[i][j] - matrixB[i][j];
                }
            }

            return matrixC;
        } else {
            return null;
        }

    }

    public static int[][] multiply(int[][] matrixA, int[][] matrixB) {

        int[][] matrixC = new int[matrixA.length][matrixB[0].length];

        if (matrixA[0].length != matrixB.length) {
            return null;
        } else {
            for (int i = 0; i < matrixC.length; i++) {
                for (int j = 0; j < matrixC[0].length; j++) {
                    int sum = 0;
                    for (int k = 0; k < matrixA[0].length; k++) {
                        sum += matrixA[i][k] * matrixB[k][j];
                    }

                    matrixC[i][j] = sum;
                }
            }

            return matrixC;
        }
    }


    public static double[][] multiply(double[][] matrixA, double[][] matrixB) {

        double[][] matrixC = new double[matrixA.length][matrixB[0].length];

        if (matrixA[0].length != matrixB.length) {
            return null;
        } else {
            for (int i = 0; i < matrixC.length; i++) {
                for (int j = 0; j < matrixC[0].length; j++) {
                    double sum = 0;
                    for (int k = 0; k < matrixA[0].length; k++) {
                        sum += matrixA[i][k] * matrixB[k][j];
                    }

                    matrixC[i][j] = sum;
                }
            }

            return matrixC;
        }
    }
}
