package homework.p2;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncQueue2<T> {
    private List<T> list = new ArrayList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();

    public void produce(List<T> elements) throws InterruptedException {
        lock.lock();
        try {
            list.addAll(elements);
            System.out.println("Produce elements: " + elements);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public List<T> consume() throws InterruptedException {
        lock.lock();
        try {
            while (list.isEmpty()) {
                notEmpty.await();
            }
            List<T> consumed = new ArrayList<>(list);
            list.clear();
            System.out.println("Consume elements: " + consumed);
            return consumed;
        } finally {
            lock.unlock();
        }
    }
}