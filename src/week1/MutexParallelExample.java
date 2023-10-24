package week1;

/**
 * @author prakashponali
 * @Date 24/10/23
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexParallelExample {
    public static void main(String[] args) {
        Lock mutex = new ReentrantLock();
        SharedResource sharedResource = new SharedResource();

        int numThreads = 5;
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new Worker(sharedResource, mutex, i));
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}




