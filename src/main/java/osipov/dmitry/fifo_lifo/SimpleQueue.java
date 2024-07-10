package osipov.dmitry.fifo_lifo;

import java.util.ArrayList;
import java.util.List;

public class SimpleQueue<T> implements Queue<T> {
    private final List<T> list = new ArrayList<>();

    @Override
    public void add(T item) {
        list.add(item);
    }

    @Override
    public T remove() {
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
