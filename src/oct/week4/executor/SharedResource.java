package oct.week4.executor;

import java.util.concurrent.locks.Lock;

/**
 * @author prakashponali
 * @Date 24/10/23
 */
public class SharedResource {

    public int inventory = 0;

    public Lock lock;


    public SharedResource(Lock lock) {
        this.lock = lock;
    }

    public int getInventory(){

        return inventory;
    }

    public void produce(int inventory) {
        this.inventory = this.inventory + inventory;
    }

    public void consume(int inventory) {
        if(inventory < this.inventory)
            this.inventory = this.inventory - inventory;
        else
            this.inventory = 0;
    }

    public Lock getMutex(){
        return lock;
    }
}
