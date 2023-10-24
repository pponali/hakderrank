package week1;

/**
 * @author prakashponali
 * @Date 24/10/23
 */
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexExample {
    public static void main(String[] args) {
        Lock mutex = new ReentrantLock();
        AtomicBoolean isItemProduced = new AtomicBoolean(false);

        Thread producer = new Thread(() -> {
            mutex.lock();
            try {
                System.out.println("Producer: Ready to produce.");
                try {
                    Thread.sleep(1000); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                isItemProduced.set(true);
                System.out.println("Producer: Producing an item.");
            } finally {
                mutex.unlock();
            }
        });

        Thread consumer = new Thread(() -> {
            mutex.lock();
            try {
                System.out.println("Consumer: Waiting for an item.");

                while (!isItemProduced.get()) {
                    try {
                        Thread.sleep(100); // Polling for simplicity
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Consumer: Consuming the item.");
            } finally {
                mutex.unlock();
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
