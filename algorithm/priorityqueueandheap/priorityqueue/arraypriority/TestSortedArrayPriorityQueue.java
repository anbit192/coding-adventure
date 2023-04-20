package priorityqueueandheap.priorityqueue.arraypriority;

public class TestSortedArrayPriorityQueue {
    public static void main(String[] args) {

        SortedArrayPriorityQueue<Integer, String> queue = new SortedArrayPriorityQueue<>();
        queue.insert(0, "A");
        queue.insert(4, "E");
        queue.insert(3, "D");
        queue.insert(2, "C");
        queue.insert(1, "B");
        queue.insert(5, "F");

        queue.removeMin();
        queue.removeMin();
        queue.removeMin();
        queue.removeMin();
        queue.removeMin();
        queue.removeMin();

        queue.print();
    }
}
