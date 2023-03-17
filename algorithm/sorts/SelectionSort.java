package sorts;

public class SelectionSort {
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

        for (int i = 0; i < array.length - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            swap++;

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        System.out.println("Swap: " + swap);

    }

    public static void print(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
