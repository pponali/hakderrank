package week4.epcilon;

/**
 * @author prakashponali
 * @Date 27/10/23
 */
public class CustomHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private Entry<K, V>[] table;
    private int size;

    public CustomHashMap() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        if (key == null) {
            putNullKey(value);
            return;
        }

        int index = hash(key);
        if (table[index] == null) {
            table[index] = new Entry<>(key, value);
            size++;
        } else {
            // Handle collisions (e.g., linear probing)
            int i = (index + 1) % table.length;
            while (i != index) {
                if (table[i] == null) {
                    table[i] = new Entry<>(key, value);
                    size++;
                    return;
                }
                i = (i + 1) % table.length;
            }
            // If we reach here, the table is full, and we should consider resizing.
        }
    }

    public V get(K key) {
        if (key == null) {
            return getNullKey();
        }

        int index = hash(key);
        if (table[index] != null && key.equals(table[index].key)) {
            return table[index].value;
        } else {
            // Handle collisions (e.g., linear probing)
            int i = (index + 1) % table.length;
            while (i != index) {
                if (table[i] != null && key.equals(table[i].key)) {
                    return table[i].value;
                }
                i = (i + 1) % table.length;
            }
            return null;
        }
    }

    public void remove(K key) {
        if (key == null) {
            removeNullKey();
            return;
        }

        int index = hash(key);
        if (table[index] != null && key.equals(table[index].key)) {
            table[index] = null;
            size--;
        } else {
            // Handle collisions (e.g., linear probing)
            int i = (index + 1) % table.length;
            while (i != index) {
                if (table[i] != null && key.equals(table[i].key)) {
                    table[i] = null;
                    size--;
                    return;
                }
                i = (i + 1) % table.length;
            }
        }
    }

    public int size() {
        return size;
    }

    private void putNullKey(V value) {
        // Handle null key, similar to handling collisions
        // You need to implement the logic for handling null key separately.
    }

    private V getNullKey() {
        // Handle null key, similar to handling collisions
        // You need to implement the logic for handling null key separately.
        return null;
    }

    private void removeNullKey() {
        // Handle removal of null key, similar to handling collisions
        // Handle removal of null key, similar to handling collisions.


        // You need to implement the logic for handling null key separately.
    }

    private int hash(K key) {
        return key.hashCode() % table.length;
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

