package homework.p2;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncQueue1<T> {
    private List<T> list = new ArrayList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition canProduce = lock.newCondition();
    private final Condition canConsume = lock.newCondition();
    private boolean isProducing = true;

    public void produce(List<T> elements) throws InterruptedException {
        lock.lock();
        try {
            while (!isProducing) {
                canProduce.await();
            }
            list.addAll(elements);
            System.out.println("Produce elements: " + elements);
            isProducing = false;
            canConsume.signal();
        } finally {
            lock.unlock();
        }
    }

    public List<T> consume() throws InterruptedException {
        lock.lock();
        try {
            while (isProducing) {
                canConsume.await();
            }
            List<T> consumed = new ArrayList<>(list);
            list.clear();
            System.out.println("Consume elements: " + consumed);
            isProducing = true;
            canProduce.signal();
            return consumed;
        } finally {
            lock.unlock();
        }
    }
}