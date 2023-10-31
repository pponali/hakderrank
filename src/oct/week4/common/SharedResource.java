package oct.week4.common;

/**
 * @author prakashponali
 * @Date 24/10/23
 */
public class SharedResource {

    public int inventory = 0;

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
}
