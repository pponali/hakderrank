package test;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.OptionalInt;

/**
 * @Author prakashponali
 * @Date 28/11/23
 * @Description
 */

@Slf4j
public class NumberDemo {
    public static void main(String[] args) {

        //int[] numbers = {2,23,19,17,64,37,28,40};
        /*int firstMax = 0, secondMax = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] > firstMax){
                firstMax = numbers[i];
            }else if(secondMax < numbers[i] && numbers[i] < firstMax){
                secondMax = numbers[i];
            }
        }
        System.out.println(secondMax);*/
        int[] numbers = {2, 23, 19, 17, 64, 23, 17, 37, 2, 19, 28, 40};
        OptionalInt optionalInt = Arrays.stream(numbers).min();

        //extend the entity with all types of inheritance strategy
        log.info("test " + optionalInt.getAsInt());
        findSecondMax(numbers);


    }
    public static int findSecondMax(int[] numbers){
        //second max from the array with out sorting
        log.info("{}",numbers);
        int max = 0;
        int secondMax = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] > max){
                secondMax = max;
                max = numbers[i];
            }else if(numbers[i] > secondMax && numbers[i] < max){
                secondMax = numbers[i];
            }
        }
        Arrays.sort(numbers);
        log.info("{}",numbers);
        log.info("{}",max);
        log.info("{}",secondMax);
        log.info("{}",Arrays.toString(numbers));

        IntSummaryStatistics stats = Arrays.stream(numbers)
                .summaryStatistics();
        System.out.println(" Max :: " + stats.getMax() + " Min :: " + stats.getMin() + "  Avg :: " + stats.getAverage() + " Count :: " + stats.getCount() + " Sum ::  " + stats.getSum());

        return 0;
    }
}
