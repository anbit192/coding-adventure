package priorityqueueandheap.priorityqueue.arraypriority;

public class TestUnsortedArrayPriorityQueue {
    public static void main(String[] args) {

        UnsortedArrayPriorityQueue<Integer, String> priorityQueue = new UnsortedArrayPriorityQueue<>();

        priorityQueue.insert(0, "A");
        priorityQueue.insert(4, "E");
        priorityQueue.insert(3, "D");
        priorityQueue.insert(2, "C");
        priorityQueue.insert(1, "B");
        priorityQueue.insert(5, "F");

        /*priorityQueue.removeMin();
        priorityQueue.removeMin();
        priorityQueue.removeMin();
        priorityQueue.removeMin();
        priorityQueue.removeMin();*/
        priorityQueue.print();



    }
}
