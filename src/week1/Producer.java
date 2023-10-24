package week1;

import java.util.concurrent.locks.Lock;

/**
 * @author prakashponali
 * @Date 24/10/23
 */
class Producer implements Runnable {
    private SharedResourceMutex sharedResource;
    private Lock mutex;
    private int id;

    public Producer(SharedResourceMutex sharedResource, Lock mutex, int id) {
        this.sharedResource = sharedResource;
        this.mutex = mutex;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) { // Produce 3 items
            mutex.lock();
            try {
                sharedResource.produce();
                System.out.println("Producer " + id + " produced an item. Supply: " + sharedResource.getInventory());
            } finally {
                mutex.unlock();
            }
        }
    }
}
