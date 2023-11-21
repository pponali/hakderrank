package week1;

import java.util.concurrent.locks.Lock;

public class Worker implements Runnable {
    private SharedResource sharedResource;
    private Lock mutex;
    private int id;

    public Worker(SharedResource sharedResource, Lock mutex, int id) {
        this.sharedResource = sharedResource;
        this.mutex = mutex;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            mutex.lock();
            try {
                sharedResource.increment();
                System.out.println("Thread " + id + ": Incremented to " + sharedResource.getValue());
            } finally {
                mutex.unlock();
            }
        }
    }
}