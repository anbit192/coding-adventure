package priorityqueueandheap.priorityqueue.linkedpriority;

public class TestLinkedPriorityQueueSorted {
    public static void main(String[] args) {

        LinkedSortedPriorityQueue<Integer, String> queue = new LinkedSortedPriorityQueue<>();

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
