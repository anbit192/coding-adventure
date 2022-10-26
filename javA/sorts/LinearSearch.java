package sorts;

public class LinearSearch {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 11, 13, 15, 17, 19, 12, 14, 16, 18, 20};
        if (existItem(array, 6)) {
            System.out.println(linearSearch(array, 100));
        } else {
            System.out.println(linearSearch(array, 100));
        }
    }

    public static boolean existItem(int[] array, int key) {

        for (int item : array) {
            if (item == key) {
                return true;
            }
        }

        return false;
    }

    public static int linearSearch(int[] array, int key) {

        for (int i = 0; i < array.length; i++) {
            if (key == array[i]) {
                return i;
            }
        }

        return -1;
    }
}
