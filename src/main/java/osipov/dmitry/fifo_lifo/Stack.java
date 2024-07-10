package osipov.dmitry.fifo_lifo;

public interface Stack<T> {
    void push(T item);
    T pop();
    boolean isEmpty();
}
