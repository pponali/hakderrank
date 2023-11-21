package main.java.week1;

/**
 * @author prakashponali
 * @Date 24/10/23
 */

import java.util.concurrent.Semaphore;

public class InventoryManagerWithSemaphore {
    private final Semaphore inventorySemaphore;
    private int availableItems;

    public InventoryManagerWithSemaphore(int capacity) {
        inventorySemaphore = new Semaphore(capacity);
        availableItems = capacity; // Initialize with full capacity
    }

    public void supplyItem(int quantity) {
        try {
            inventorySemaphore.acquire();
            availableItems += quantity;
            System.out.println("Supplied " + quantity + " item(s). Available items: " + availableItems);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void demandItem(int quantity) {
        try {
            inventorySemaphore.acquire();
            if (availableItems >= quantity) {
                availableItems -= quantity;
                System.out.println("Demanded " + quantity + " item(s). Available items: " + availableItems);
            } else {
                System.out.println("Not enough items in inventory.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            inventorySemaphore.release();
        }
    }

    public int getAvailableItems() {
        return availableItems;
    }

    public static void main(String[] args) {
        InventoryManagerWithSemaphore inventoryManager = new InventoryManagerWithSemaphore(10);

        Runnable supplier = () -> {
            for (int i = 0; i < 5; i++) {
                inventoryManager.supplyItem(2);
                try {
                    Thread.sleep(100); // Simulate some processing
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable customer = () -> {
            for (int i = 0; i < 3; i++) {
                inventoryManager.demandItem(1);
                try {
                    Thread.sleep(100); // Simulate some processing
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread supplierThread = new Thread(supplier);
        Thread customerThread = new Thread(customer);

        supplierThread.start();
        customerThread.start();

        try {
            supplierThread.join();
            customerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

