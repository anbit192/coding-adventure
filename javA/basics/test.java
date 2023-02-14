package basics;

public class test {
    public static void main(String[] args) {


        int[] array = { 99 ,-2, 3,3, -10, -10, 3, 2, 19, 18, 21, -36, -192};

        boolean sorted = false;
        int temp;

        while (sorted == false) {
            sorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] > array[i - 1]) {
                    sorted = false;
                    temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }
}
