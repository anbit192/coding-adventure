package SortingAndSearchingExercises;


public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 8, 1, 5, 8, 9, -10, 7, 3, 0, 123, 76, 23, 45};

        selectionSort(array);
    }

    public static void print(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }

        System.out.println();
    }

    public static int findMinIndex(int[] array, int startIndex) {
        int max = array[startIndex];
        int maxIndex = 0;

        for (int i = startIndex; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        for (int i = startIndex; i < array.length; i++) {
            if (array[i] == max) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length ; i++) {

            System.out.println("Loop:" + (i + 1));
            print(array);

            int minIndex = findMinIndex(array, i);

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}