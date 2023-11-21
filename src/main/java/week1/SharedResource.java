package week1;

/**
 * @author prakashponali
 * @Date 24/10/23
 */
public class SharedResource {
    private int value = 0;

    public void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }
}
