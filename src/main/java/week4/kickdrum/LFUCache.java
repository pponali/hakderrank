package week4.kickdrum;

/**
 * @Author prakashponali
 * @Date 21/11/23
 * @Description
 */
import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    private final Map<Integer, Node> nodeMap;
    private final Map<Integer, DoublyLinkedList> countMap;
    private final int capacity;
    private int minFrequency;

    private class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1; // default frequency is 1
        }
    }

    private class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0); // dummy head
            tail = new Node(0, 0); // dummy tail
            head.next = tail;
            tail.prev = head;
        }

        void addNode(Node node) {
            Node headNext = head.next;
            head.next = node;
            node.prev = head;
            node.next = headNext;
            headNext.prev = node;
            size++;
        }

        void removeNode(Node node) {
            Node nextNode = node.next;
            Node prevNode = node.prev;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }

        Node removeTail() {
            if (size > 0) {
                Node node = tail.prev;
                removeNode(node);
                return node;
            } else {
                return null;
            }
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
        minFrequency = 0;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }
        Node node = nodeMap.get(key);
        updateNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            updateNode(node);
        } else {
            if (nodeMap.size() == capacity) {
                DoublyLinkedList minFreqList = countMap.get(minFrequency);
                Node evict = minFreqList.removeTail();
                nodeMap.remove(evict.key);
            }
            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            countMap.putIfAbsent(1, new DoublyLinkedList());
            countMap.get(1).addNode(newNode);
            minFrequency = 1;
        }
    }

    private void updateNode(Node node) {
        int currentFreq = node.freq;
        DoublyLinkedList currentList = countMap.get(currentFreq);
        currentList.removeNode(node);

        if (currentFreq == minFrequency && currentList.size == 0) {
            minFrequency++;
        }

        node.freq++;
        countMap.putIfAbsent(node.freq, new DoublyLinkedList());
        countMap.get(node.freq).addNode(node);
    }
}
