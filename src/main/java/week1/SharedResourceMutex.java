package week1;

/**
 * @author prakashponali
 * @Date 24/10/23
 */
class SharedResourceMutex {
    private int inventory = 0;
    private static final int MAX_SUPPLY = 5;

    public void produce() {
        if (inventory < MAX_SUPPLY) {
            inventory++;
        }
    }

    public void consume() {
        if (inventory > 0) {
            inventory--;
        }
    }

    public int getInventory() {
        return inventory;
    }
}