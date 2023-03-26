package adtstackandqueue.queue;

public class TestArrayQueue {
    public static void main(String[] args) {
        //constructor
        QueueInterface<String> queue = new ArrayQueue<>(2);

        //enqueue
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        //toString
        System.out.println(queue);

        //dequeue
        queue.dequeue();
        queue.dequeue();

        System.out.println(queue);

        //iterator
        for (String str : queue) {
            System.out.println(str);
        }
    }
}
