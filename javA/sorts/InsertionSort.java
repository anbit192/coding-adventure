package sorts;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 8, 1, 5, 8, 9, -10, 7, 3, 0, 123, 76, 23, 45};

        insertionSort(array);
        print(array);
    }

    public static void print(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }

        System.out.println();
    }

    /*
                                1.Move element( that is BIGGER than "key") 1 step to the RIGHT.
                                2.Place the key just BEHIND the element that is SMALLER than "key".
                                    If the CURRENT "key" is the SMALLEST element in the SORTED list,
                                     place the key at the BEGINNING of the sorted list.

                                eg. 4|2 5 1
                                 => 2 4 5 1 (4 is bigger than 2 (key) so 4 moved to the right 1 step.
                                             2 (key) moved to the beginning of the sorted list.)

                                    2 4|5 1 (the key is now 5)
                                 => 2 4 5 1

                                    2 4 5|1 (key is 1)
                                 => 1 2 4 5  (2, 4, 5 are all bigger than the key => 2, 4, 5 move to the right 1 step.
                                              The key is the smallest in the sorted list => move to the beginning of the sorted list.
     */
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {

            int key = array[i]; /*the left-most element from the un-sorted list
                                eg. array : 4   2   5   1
                                start :     4 | 2   5   1 => 2 is the key
                                           ---  ---------
                                           sort   unsort
            */
            int j = i - 1;

            System.out.println("key: " + key);

            while (j >= 0 && key < array[j]) { /*  iterate from THE END of the SORTED LIST until key >= array[j].
            */
                array[j + 1] = array[j]; // array[j] > key => move array[j] to THE RIGHT 1 step.
                j--; //descend j
            }

            array[j + 1] = key; // Outside while block => key >= array[j].
                                // => Place the key just behind the array[j].
            print(array);

        }
    }
}
