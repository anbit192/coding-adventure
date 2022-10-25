package SortingAndSearchingExercises;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 8, 1, 5, 8, 9, -10, 7, 3, 0, 123, 76, 23, 45};

        bubbleSort(array);
        print(array);
    }

    public static void print(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }

        System.out.println();
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}
