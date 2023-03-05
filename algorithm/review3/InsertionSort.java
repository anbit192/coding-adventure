package review3;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[50];

        for (int i = 49; i >= 0; i--) {
            //array[i] = (int) ((Math.random()) * 100.0 + 1);
            array[49 - i] = i;
        }


        long start = System.nanoTime();

        sort(array);

        long end = System.nanoTime();
        long time = end - start;

        print(array);


        System.out.println(time);


    }

    public static void sort(int[] array) {
        int swap = 0;
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                swap++;
                array[j + 1] = array[j];
                j--;

            }


            array[j + 1] = key;


        }

        System.out.println(swap);
    }


    public static void print(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
