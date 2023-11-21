package week1;

import java.util.concurrent.locks.Lock;

/**
 * @author prakashponali
 * @Date 24/10/23
 */
class Consumer implements Runnable {
    private final SharedResourceMutex sharedResource;
    private final Lock mutex;
    private final int id;

    public Consumer(SharedResourceMutex sharedResource, Lock mutex, int id) {
        this.sharedResource = sharedResource;
        this.mutex = mutex;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) { // Consume 3 items
            mutex.lock();
            try {
                sharedResource.consume();
                System.out.println("Consumer " + id + " consumed an item. Supply: " + sharedResource.getInventory());
            } finally {
                mutex.unlock();
            }
        }
    }
}