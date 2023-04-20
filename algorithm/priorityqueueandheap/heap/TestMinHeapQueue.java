package priorityqueueandheap.heap;

public class TestMinHeapQueue {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> heap = new MinHeapPriorityQueue<>();

        heap.insert(3, "C");
        heap.print();

        heap.insert(1, "A");
        heap.print();

        heap.insert(6, "F");
        heap.print();

        heap.insert(2, "B");
        heap.print();

        heap.insert(5, "E");
        heap.print();

        heap.insert(4, "D");
        heap.print();
        System.out.println(heap.size());
        System.out.println("=========================\n\n\n");


        heap.removeMin();
        heap.print();
        System.out.println(heap.size());


        heap.removeMin();
        heap.print();
        System.out.println(heap.size());

        heap.removeMin();
        heap.print();
        System.out.println(heap.size());

        heap.removeMin();
        heap.print();
        System.out.println(heap.size());

        heap.removeMin();
        heap.print();
        System.out.println(heap.size());

        heap.removeMin();
        heap.print();
        System.out.println(heap.size());



    }
}
