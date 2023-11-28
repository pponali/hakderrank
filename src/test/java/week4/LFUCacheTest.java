package week4;

/**
 * @Author prakashponali
 * @Date 21/11/23
 * @Description
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week4.kickdrum.LFUCache;

import static org.junit.jupiter.api.Assertions.*;

class LFUCacheTest {

    private LFUCache cache;

    @BeforeEach
    void setUp() {
        cache = new LFUCache(2);
    }

    @Test
    void testCacheCapacity() {
        cache.put(1, 10);
        cache.put(2, 20);
        assertEquals(10, cache.get(1));
        assertEquals(20, cache.get(2));

        cache.put(3, 30); // Should evict key 1
        assertEquals(-1, cache.get(1));
        assertEquals(20, cache.get(2));
        assertEquals(30, cache.get(3));
    }

    @Test
    void testCacheEvictionLFU() {
        cache.put(1, 10);
        cache.put(2, 20);
        cache.get(1); // Increase frequency of key 1

        cache.put(3, 30); // Should evict key 2
        assertEquals(10, cache.get(1));
        assertEquals(-1, cache.get(2));
        assertEquals(30, cache.get(3));
    }

    @Test
    void testCacheUpdate() {
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(1, 100); // Update value for key 1

        assertEquals(100, cache.get(1));
        assertEquals(20, cache.get(2));
    }

    @Test
    void testCacheEvictionOrder() {
        cache.put(1, 10);
        cache.put(2, 20);
        cache.get(1); // Increase frequency of key 1
        cache.get(2); // Increase frequency of key 2
        cache.get(1); // Increase frequency of key 1

        cache.put(3, 30); // Should evict key 2
        assertEquals(10, cache.get(1));
        assertEquals(-1, cache.get(2));
        assertEquals(30, cache.get(3));
    }
}

