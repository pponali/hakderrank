package week1;

/**
 * @author prakashponali
 * @Date 24/10/23
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexSupplyDemandExample {
    public static void main(String[] args) {
        Lock mutex = new ReentrantLock();
        SharedResourceMutex sharedResource = new SharedResourceMutex();

        int numProducers = 3;
        int numConsumers = 2;

        Thread[] producerThreads = new Thread[numProducers];
        Thread[] consumerThreads = new Thread[numConsumers];

        for (int i = 0; i < numProducers; i++) {
            producerThreads[i] = new Thread(new Producer(sharedResource, mutex, i));
            producerThreads[i].start();
        }

        for (int i = 0; i < numConsumers; i++) {
            consumerThreads[i] = new Thread(new Consumer(sharedResource, mutex, i));
            consumerThreads[i].start();
        }

        for (int i = 0; i < numProducers; i++) {
            try {
                producerThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < numConsumers; i++) {
            try {
                consumerThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}






