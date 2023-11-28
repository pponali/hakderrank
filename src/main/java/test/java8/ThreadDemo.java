package test.java8;

import java.util.concurrent.Callable;

/**
 * @Author prakashponali
 * @Date 28/11/23
 * @Description
 */
public class ThreadDemo {

    //one thread is printing even numbers and another thread is printing odd numbers
    //code to print natural number by syncing both the threads using multi thread concept.
    public static void main(String[] args) {
        int[] numbers = {2,23,19,17,64,23,17,37,2,19,28,40};
        OddEvenThread oddEvenThread = new OddEvenThread();
        oddEvenThread.printEven();
        oddEvenThread.printOdd();
    }

    private static class OddEvenThread {
        private final EvenThread even;
        private final OddThread odd;

        public OddEvenThread() {
            this.even = new EvenThread();
            this.odd = new OddThread();
            //logic to print number in the natural order
            //logic to print number in the natural order and even numbers first and odd numbers next
            even.start();
            odd.start();
            try {
                even.join();
                odd.join();
            }
            catch (InterruptedException e) {

            }
        }

        public void printEven() {

        }

        public void printOdd() {
        }

        private class OddThread extends Thread{





            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(i);
                    }
                }
            }
        }

        private class EvenThread extends Thread{

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 1) {
                        System.out.println(i);
                    }
                }
            }
        }
    }
}
