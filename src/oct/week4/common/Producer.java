package oct.week4.common;

import java.util.concurrent.locks.Lock;

/**
 * @author prakashponali
 * @Date 24/10/23
 */
public class Producer implements Runnable {

    public int threadId = 0;

    public Lock lock;

    public SharedResource sharedResource;

    public Producer(int threadId, Lock lock, SharedResource sharedResource) {
        this.threadId = threadId;
        this.lock = lock;
        this.sharedResource = sharedResource;

    }

    @Override
    public void run() {
        try {
            lock.lock();
            sharedResource.produce(1);
            System.out.println("Producer " + threadId + " adding the inventory :: " + sharedResource.getInventory());
        }finally {
            lock.unlock();
        }
    }
}
