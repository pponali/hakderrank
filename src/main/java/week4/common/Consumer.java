package week4.common;

import java.util.concurrent.locks.Lock;

/**
 * @author prakashponali
 * @Date 24/10/23
 */
public class Consumer implements Runnable {

    public int threadId = 0;
    public Lock lock;

    public SharedResource sharedResource;

    public Consumer(int threadId, Lock lock, SharedResource sharedResource) {
        this.sharedResource = sharedResource;
        this.lock = lock;
        this.threadId = threadId;
    }
    @Override
    public void run() {
        try{
            lock.lock();
            sharedResource.consume(1);
            System.out.println("Consumer " + threadId + " is consuming. now the Current Inventory is " + sharedResource.getInventory());
        } finally {
            lock.unlock();
        }

    }
}
