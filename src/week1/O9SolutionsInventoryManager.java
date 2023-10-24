package week1;

import java.util.TreeMap;

/**
 * @author prakashponali
 * @Date 24/10/23
 */
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

    public float GetInventory(int bucket) {
        // Retrieve the inventory for the specified bucket.
        float inventory = 0f;
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

        System.out.println("Inventory at bucket 2: " + manager.GetInventory(2)); // -5.0
        System.out.println("Inventory at bucket 3: " + manager.GetInventory(3)); // 12.0
    }



}
