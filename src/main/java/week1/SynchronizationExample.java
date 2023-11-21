package main.java.week1;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author prakashponali
 * @Date 24/10/23
 */
public class SynchronizationExample {
    public static void main(String[] args) {
        final Object monitor = new Object();
        AtomicBoolean isItemProduced = new AtomicBoolean(false);

        Thread producer = new Thread(() -> {
            synchronized (monitor) {
                System.out.println("Producer: Ready to produce.");
                try {
                    Thread.sleep(1000); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                isItemProduced.set(true);
                System.out.println("Producer: Producing an item.");
                monitor.notify(); // Notify the consumer
            }
        });

        Thread consumer = new Thread(() -> {
            synchronized (monitor) {
                System.out.println("Consumer: Waiting for an item.");

                while (!isItemProduced.get()) {
                    try {
                        monitor.wait(); // Wait for notification from the producer
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Consumer: Consuming the item.");
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
