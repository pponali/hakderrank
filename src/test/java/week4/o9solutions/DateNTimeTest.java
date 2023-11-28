package week4.o9solutions;

import org.junit.jupiter.api.Test;
import week4.sailsoftware.DateNTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author prakashponali
 * @Date 20/11/23
 * @Description
 */


public class DateNTimeTest {
    @Test
    public void testDateNTime() {
        DateNTime dateNTime = new DateNTime();
        assertArrayEquals(DateNTime.printEvenNumbers(new int[]{2,4,6,3,4,56,7,8,1,9,7}), new int[]{2,4,6,3,4,56,7,8,1,9,7});
    }


}
