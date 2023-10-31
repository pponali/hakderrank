package oct.week4.common;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author prakashponali
 * @Date 24/10/23
 */
public class ParallelThreads {
    public static void main(String[] args) throws InterruptedException {
        Lock mutex = new ReentrantLock();
        SharedResource sharedResource = new SharedResource();

        Thread[] producers = new Thread[5];
        Thread[] consumers = new Thread[10];

        for(int i = 0; i < 5; i++){
            producers[i]  = new Thread(new Producer(i, mutex, sharedResource));
        }

        for(int i = 0; i < 10; i++){
            consumers[i] = new Thread(new Consumer(i, mutex, sharedResource));
        }

        for(int i = 0; i < 5; i++){
            producers[i].start();
        }
        for(int i = 0; i < 5; i++){
            consumers[i].start();
        }
        for(int i = 0; i < 5; i++){
            producers[i].join();
        }
        for(int i = 0; i < 10; i++){
            consumers[i].join();
        }


    }
}
