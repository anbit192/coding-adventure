package priorityqueueandheap.heap;

public class HeapSort {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, Integer> heap = new MinHeapPriorityQueue<>();

        int[] array = new int[]{3, 5, 1, 6, 19, 23, 0, 0, 1, 1, -2, 3, 123, 65, 7, 4, 2, 22, 85, 192, -23, -994};
        for (int i = 0; i < array.length; i++) {
            heap.insert(array[i], 0);
        }

        heap.print();

        for (int i = 0; i < array.length; i++) {
            array[i] = heap.removeMin().getKey();
        }

        heap.print();

        for (int item : array) {
            System.out.print(item + " ");
        }


        System.out.println();
    }
}
