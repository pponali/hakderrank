package week4.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

/**
 * @author prakashponali
 * @Date 24/10/23
 */
public class Producer implements Callable<Integer> {

    public int threadId = 0;

    public Lock lock;

    public SharedResource sharedResource;

    public Producer(int threadId, Lock lock, SharedResource sharedResource) {
        this.threadId = threadId;
        this.lock = lock;
        this.sharedResource = sharedResource;

    }


    @Override
    public Integer call() throws Exception {
        try {
            lock.lock();
            sharedResource.produce(1);
            System.out.println("Producer " + threadId + " adding the inventory :: " + sharedResource.getInventory());
            return sharedResource.getInventory();
        }finally {
            lock.unlock();
        }

    }
}
