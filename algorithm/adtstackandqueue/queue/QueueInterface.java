package adtstackandqueue.queue;

import java.util.Iterator;

public interface QueueInterface<E> extends Iterable<E> {

    void enqueue(E element);
    E dequeue();
    boolean isEmpty();
}
