package week1;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author prakashponali
 * @Date 12/10/23
 */
public class DateFormat {

    public static void main(String[] args) {
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("hh:mm:ssa");
        SimpleDateFormat newDateFormat = new SimpleDateFormat("HH:mm:ss");
        try{
            Date givenDate = oldDateFormat.parse("07:05:45PM");
            System.out.println(newDateFormat.format(givenDate)) ;
        }catch(Exception e)
        {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
