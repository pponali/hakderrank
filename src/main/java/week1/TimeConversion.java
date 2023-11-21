package main.java.week1;

import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TimeConversion {
    public static void main(String[] args) throws ParseException {
        String date = "12:01:01";

        DateTimeFormatter dateFormat = DateTimeFormatter.ISO_LOCAL_TIME;
        LocalTime lt = LocalTime.parse(date,dateFormat);

        System.out.println(lt);
        TimeConversion timeConversion = new TimeConversion();
        ArrayList<Integer> integer = new ArrayList<>();
        integer.add(-98);
        integer.add(54);
        integer.add(-52);
        integer.add(15);
        integer.add(23);
        integer.add(-97);
        integer.add(12);
        integer.add(-64);
        integer.add(52);
        integer.add(85);


        timeConversion.solve(integer);

        timeConversion.pow(-1,1,20);
    }



    public int solve(ArrayList<Integer> A) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Integer intess = null;

        for(int i=0;i< A.size();i++){
            if(A.get(i) != 0 && A.get(i) % 2 == 0) {
                max = Math.max(max, A.get(i));
            }
            if(A.get(i) != 0 && A.get(i) % 2 == 1) {
                min = Math.min(min, A.get(i));
            }
        }

        return max - min;
    }


    public int pow(int A, int B, int C) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        if(A == 0 || B == 0|| C == 0)
            return 0;
        else  {
            Double doubledd = Double.valueOf(Math.pow(A,B));
            doubledd.intValue();
            int intpower = doubledd.intValue();
            return intpower % C;
        }
    }
}
