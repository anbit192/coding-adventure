package adtstackandqueue.queue;

public class TestLinkedQueue {
    public static void main(String[] args) {

        //constructor
        QueueInterface<String> queue = new LinkedQueue<>();

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

        queue.dequeue();
        queue.dequeue();

        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);

        //iterator
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        for (String str : queue) {
            System.out.println(str);
        }

        //isEmpty
        System.out.println(queue.isEmpty());
    }
}
