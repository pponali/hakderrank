package week4.o9solutions;

/**
 * @Author prakashponali
 * @Date 24/11/23
 * @Description
 */

import org.junit.jupiter.api.Test;
import week4.creditvidya.LRUCache;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
class LRUCacheTest {

    @Test
    void testCachePutAndGet() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 10);
        cache.put(2, 20);

        assertEquals(10, cache.get(1), "Cache get operation failed.");
        assertEquals(20, cache.get(2), "Cache get operation failed.");
    }

    @Test
    void testCacheEviction() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30); // This should evict key 1

        assertEquals(-1, cache.get(1), "Cache eviction failed.");
        assertEquals(20, cache.get(2), "Cache get operation failed after eviction.");
        assertEquals(30, cache.get(3), "Cache get operation failed after eviction.");
    }

    @Test
    void testCacheUpdate() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(1, 100); // Update key 1

        assertEquals(100, cache.get(1), "Cache update operation failed.");
        assertEquals(20, cache.get(2), "Cache get operation failed after update.");
    }

    @Test
    void testCacheLRUOrder() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.get(1);      // Access key 1
        cache.put(3, 30);  // This should evict key 2

        assertEquals(10, cache.get(1), "Cache eviction order incorrect.");
        assertEquals(-1, cache.get(2), "Cache eviction order incorrect.");
        assertEquals(30, cache.get(3), "Cache get operation failed.");
    }
}

