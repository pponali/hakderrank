package week4.epcilon;




import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author prakashponali
 * @Date 21/11/23
 * @Description
 */
class CustomHashMapTest {

    @BeforeEach
    void setUp() {
        CustomHashMap<String, String> customHashMap = new CustomHashMap<>();
        customHashMap.put("1", "1");
        customHashMap.put("2", "2");
        customHashMap.put("3", "3");
        customHashMap.put("4", "4");
        customHashMap.put("5", "5");
    }

    @AfterEach
    void tearDown() {
        CustomHashMap<String, String> customHashMap = new CustomHashMap<>();
    }

    @Test
    void put() {
        //
    }

    @Test
    void get() {
    }

    @Test
    void remove() {
    }

    @Test
    void size() {
    }
}