package week4.o9solutions;


/**
 * <img src="problem_statement.png"/>
 * if Wait() is called more times than Signal(), the _currAvail variable can go negative.
 * In the Wait() method, there's no time limit for waiting. If _currAvail is never decremented
 *  due to a lack of corresponding Signal() calls, the code can potentially wait indefinitely on Monitor.Wait(_mutex). This can result in a deadlock.
 *  There's no way to specify a timeout for the Wait() method. there should be wait method available to specify the timeout.
 *  code is not handling the waits properly. we need to have while around wait to check the availability of the resource.
 * <img src="img.png">
 * @author prakashponali
 * @Date 24/10/23
 *
 *
 **/



import java.util.TreeMap;
public class O9SolutionsInventoryManager {

    private final TreeMap<Integer, Float> inventoryTree;

    public O9SolutionsInventoryManager() {
        inventoryTree = new TreeMap<>();
    }

    public void AddSupply(int bucket, float delta) {
        // If the bucket already exists, add the supply to its value.
        // If it doesn't exist, create a new entry.
        inventoryTree.put(bucket, inventoryTree.getOrDefault(bucket, 0f) + delta);
    }

    public void AddDemand(int bucket, float delta) {
        // If the bucket already exists, subtract the demand from its value.
        // If it doesn't exist, create a new entry.
        inventoryTree.put(bucket, inventoryTree.getOrDefault(bucket, 0f) - delta);
    }

    //get inventory should be O(1)

    public float GetInventory(int bucket) {
        // Retrieve the inventory for the specified bucket.
        float inventory = 0f;
        //get the map entries till the specified bucket number.
        for (int b : inventoryTree.headMap(bucket, true).keySet()) {

            inventory += inventoryTree.get(b);
        }
        return inventory;
    }

    public static void main(String[] args) {
        O9SolutionsInventoryManager manager = new O9SolutionsInventoryManager();

        manager.AddSupply(2, 50);
        manager.AddDemand(3, 25);
        manager.AddDemand(2, 30);

        System.out.println("Inventory at bucket 2: " + manager.GetInventory(2)); // 20.0
        System.out.println("Inventory at bucket 3: " + manager.GetInventory(10)); // -5.0
    }



}

