package week4.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

/**
 * @author prakashponali
 * @Date 24/10/23
 */
public class Consumer implements Callable<Integer> {

    public int threadId = 0;
    public Lock lock;

    public SharedResource sharedResource;

    public Consumer(int threadId, Lock lock, SharedResource sharedResource) {
        this.sharedResource = sharedResource;
        this.lock = lock;
        this.threadId = threadId;
    }
    @Override
    public Integer call() {
        try{
            lock.lock();
            sharedResource.consume(1);
            System.out.println("Consumer " + threadId + " is consuming. now the Current Inventory is " + sharedResource.getInventory());
            return sharedResource.getInventory();
        } finally {
            lock.unlock();
        }

    }
}
