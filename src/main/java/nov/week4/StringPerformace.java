package nov.week4;

import java.time.Duration;

/**
 * @Author prakashponali
 * @Date 24/11/23
 * @Description
 */
public class StringPerformace {

    public static void main(String[] args) {
       long start = System.currentTimeMillis();
       stringContatinate();
       long end = System.currentTimeMillis();
        System.out.println(" String " + (end - start));

        start = System.currentTimeMillis();
        stringBuffer();
        end = System.currentTimeMillis();
        System.out.println(" String Buffer " + (end - start));

        start = System.currentTimeMillis();
        stringBuffer();
        end = System.currentTimeMillis();
        System.out.println(" String Builder " + (end - start));

    }

    public static void stringContatinate(){
        String s =  "prakash";
        for(int i = 0; i < 10000; i++) {
            s += "ponali";
        }
    }

    public static void stringBuffer(){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 10000; i++){
            sb.append("ponali");
        }

    }

    public static void stringBuilder(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 10000; i++){
            stringBuilder.append("ponali");
        }
    }
}
