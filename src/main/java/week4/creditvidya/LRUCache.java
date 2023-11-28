package week4.creditvidya;

/**
 * @Author prakashponali
 * @Date 21/11/23
 * @Description
 */
import java.util.HashMap;

public class LRUCache {

    private final HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    private final int capacity;
    private int size;
    private final DLinkedNode head, tail;

    // Node of a doubly linked list
    static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; // cache miss
        }
        // Move the accessed node to the head (most recently used)
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            size++;

            if (size > capacity) {
                // Pop the least recently used item
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            // Update the value and move it to the head
            node.value = value;
            moveToHead(node);
        }
    }

    private void addNode(DLinkedNode node) {
        // Always add the new node right after head
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        // Remove an existing node from the linked list
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node) {
        // Move certain node in between to the head
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        // Pop the current tail
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

