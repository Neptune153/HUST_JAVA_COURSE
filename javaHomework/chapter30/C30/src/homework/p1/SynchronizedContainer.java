package homework.p1;

import java.util.ArrayList;
import java.util.List;

class SynchronizedContainer<T> {
    private List<T> elements = new ArrayList<>();

    public synchronized void add(T e) {
        elements.add(e);
    }

    public synchronized T remove(int index) {
        return elements.remove(index);
    }

    public synchronized int size() {
        return elements.size();
    }

    public synchronized T get(int index) {
        return elements.get(index);
    }
}