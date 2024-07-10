package osipov.dmitry.fifo_lifo;

import java.util.ArrayList;
import java.util.List;

public class SimpleStack<T> implements Stack<T> {
    private final List<T> list = new ArrayList<>();

    @Override
    public void push(T item) {
        list.addFirst(item);
    }

    @Override
    public T pop() {
        return list.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
