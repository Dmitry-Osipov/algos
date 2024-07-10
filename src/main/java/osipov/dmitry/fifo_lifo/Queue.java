package osipov.dmitry.fifo_lifo;

public interface Queue<T> {
    void add(T item);
    T remove();
    boolean isEmpty();
}
