package review4.list;

public interface ListInterface<T> extends Iterable<T> {
    void add(T data);
    T get(int index);
    void set(int index, T data);
    void remove(T data);
    boolean isContain(T data);
    int size();
    boolean isEmpty();
}
