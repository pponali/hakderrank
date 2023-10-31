package oct.week4.executor;

import oct.week4.executor.SharedResource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author prakashponali
 * @Date 24/10/23
 */
public class ExecutorExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //ExecutorService service = Executors.unconfigurableExecutorService();
        //ExecutorService service1 = Executors.unconfigurableScheduledExecutorService();
        ExecutorService service2 = Executors.newCachedThreadPool();
        ExecutorService service3 = Executors.newFixedThreadPool(5);
        ExecutorService service4 = Executors.newSingleThreadExecutor();
        ExecutorService service5 = Executors.newWorkStealingPool();
        ExecutorService service6 = Executors.newWorkStealingPool(5);
        ExecutorService service8 = Executors.newSingleThreadScheduledExecutor();
        ExecutorService service9 = Executors.newScheduledThreadPool(5);
        //ExecutorService service10 = Executors.newThreadPerTaskExecutor();


        Callable<String> task1 = () -> {
            System.out.println("Hello World1"); return "1";
        };
        Callable<String> task2 = () -> {
            System.out.println("Hello World2"); return "2";
        };
        Callable<String> task3 = () -> {
            System.out.println("Hello World3"); return "3";
        };
        Runnable task4 = () -> System.out.println("Hello World4");
        Runnable task5 = () -> System.out.println("Hello World5");
        Runnable task6 = () -> System.out.println("Hello World6");
        service2.submit(task1);
        service2.submit(task2);
        service2.submit(task3);
        service2.execute(task4);
        service2.execute(task5);
        service2.execute(task6);
        List<Callable<String>> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        //service2.shutdown();
        service2.invokeAll(tasks);
        //service2.shutdown();
        String s1 = service2.isTerminated() ? "prakash ponalitest " : "prakashponaliasdfasd";
        String s = service2.isShutdown() ? "prakash ponali " : " prakash ponali ";
        System.out.println(s + s1 + service2.isShutdown());

        SharedResource sharedResouce = new SharedResource(new ReentrantLock());
        Lock mutex = sharedResouce.getMutex();
        Producer producer1 = new Producer(1, mutex, sharedResouce);
        Producer producer2 = new Producer(2, mutex, sharedResouce);
        Producer producer3 = new Producer(3, mutex, sharedResouce);
        List<Callable<Integer>> producers = new ArrayList<>();
        producers.add(producer1);
        producers.add(producer2);
        producers.add(producer3);
        service2.invokeAll(producers);
        Consumer consumer1 = new Consumer(1, mutex, sharedResouce);

        Consumer consumer2 = new Consumer(2, mutex, sharedResouce);
        Consumer consumer3 = new Consumer(3, mutex, sharedResouce);
        List<Callable<Integer>> consumers = new ArrayList<>();
        consumers.add(consumer1);
        consumers.add(consumer2);
        consumers.add(consumer3);
        service2.invokeAll(consumers);
        Future<Integer> future1 = service2.submit(consumer1);
        Future<Integer> future2 = service2.submit(consumer1);
        Future<Integer> future3 = service2.submit(consumer1);

        System.out.println(future1.get());

    }
}
