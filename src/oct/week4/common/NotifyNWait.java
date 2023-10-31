package oct.week4.common;

/**
 * @author prakashponali
 * @Date 24/10/23
 */
public class NotifyNWait {

    public static void main(String[] args) {
        NotifyNWait obj = new NotifyNWait();
        Thread t1 = new Thread(() -> {
            try {
                obj.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                obj.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        t1.start();
        t2.start();
    }

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread running...");
            wait();
            System.out.println("Producer thread resumed...");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        synchronized (this) {
            System.out.println("Consumer thread running...");
            notify();
        }
    }
}
