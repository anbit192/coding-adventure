package SortingAndSearchingExercises;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 8, 1, 5, 8, 9, -10, 7, 3, 0, 123, 76, 23, 45, 999};
        sortArray(array);

        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();

        System.out.println(binarySearch(array, 999, 0, array.length-1));
        System.out.println(binarySearch(array, 5));
    }

    public static void sortArray(int[] array) {
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

    public static boolean binarySearch(int[] array, int key) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        int middleIndex = (startIndex + endIndex) / 2;

        if (array.length<=1) {
            if (array[startIndex] == key) {
                return true;
            } else if (array[startIndex] != key && array[endIndex] != key) {
                return false;
            }
        }

        while (array[middleIndex] != key) {
            middleIndex = (startIndex + endIndex) / 2;
            if (key == array[middleIndex]) {
                return true;
            } else if (key < middleIndex) {
                endIndex = middleIndex;
            } else if (key > middleIndex) {
                startIndex = middleIndex;
            }
        }

        return false;
    }

    public static int binarySearch(int[] array, int key, int startIndex, int endIndex) {
        if (startIndex == endIndex-1) {

            if (array[startIndex] == key || array[endIndex] == key) {
                return startIndex;
            } else {
                return -1;
            }


        } else {
            int middleIndex = (startIndex + endIndex) / 2;

            if (array[middleIndex] == key) {
                return middleIndex;

            } else if (key < middleIndex) {
                endIndex = middleIndex;

            } else if (key > middleIndex) {
                startIndex = middleIndex;
            }


            return binarySearch(array, key, startIndex, endIndex);
        }
    }
}
