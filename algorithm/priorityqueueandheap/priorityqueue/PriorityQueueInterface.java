package priorityqueueandheap.priorityqueue;

public interface PriorityQueueInterface<K, E> {
    int size();
    boolean isEmpty();
    void insert(Entry<K, E> entry);
    void insert(K key, E value);
    Entry<K, E> removeMin();
    Entry<K, E> min();

}
