package week4.sailsoftware;

import java.util.Arrays;
import java.util.Date;

/**
 * @Author prakashponali
 * @Date 17/11/23
 * @Description
 */
public class DateNTime {

    public static void main(String[] args) {
        System.out.println(new Date());

        int[] arry = new int[]{2,4,6,3,4,56,7,8,1,9,7};

        //int a;
        System.out.println(Arrays.toString(Arrays.stream(arry).filter(a -> a % 2 == 0).toArray()));

    }
    public static int[] printEvenNumbers(int[] a) {
        for(int i = 0; i < a.length; i++) {
            if(a[i] % 2 != 0) {
                a[i] = 0;
            }
        }
        return a;
    }


}
