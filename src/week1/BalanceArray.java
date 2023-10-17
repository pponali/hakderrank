package week1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Company : edelmanfinancialengines
 *
 * Problem :- Check if the array is balanced array or not.
 *
 * Description:- A balanced array is defined to be an array where for every value n in the array, -n also is in the array.
 *
 *
 *
 * Example 1:- {-2, 3, 2, -3} is a balanced array.
 *
 * Example 2:- {1,1,-1,-1} is a balanced array.
 *
 * Example 3:- {1,1,-1} is a NOT balanced array.
 *
 * Example 4:- {-2, 3, 2, -3, 0, 5,-5} is a balanced array.
 *
 * Example 5:- {1, 2, -3} is NOT a balanced array.
 *
 * Example 6:- {-3,-2, -3, -2, 4, 1, 4, 4} 1 , 3, 2, -4, -1} is NOT a balanced array
 *
 *
 *
 * Note:-
 *
 * 1. Zeroes can be ignored.
 *
 * 2. There can be duplicates in the array. Every duplicate n needs to have -n
 *
 * @author prakashponali
 * @Date 17/10/23
 */
public class BalanceArray {

    public static void main(String[] args) {
        System.out.println(isBalancedArray(new int[]{1, 1, -1}));
    }

    private static boolean isBalancedArray(final int[] ints) {
        boolean isBalanced = true;
        Map<Integer, Integer> occurrence = new HashMap<>();

        for (int in : ints) {
            if (in != 0) {
                if (occurrence.containsKey(in)) {
                    occurrence.put(in, occurrence.get(in) + 1);
                } else {
                    occurrence.put(in, 1);
                }
            }
        }
        Set<Integer> entrySet = occurrence.keySet();
        for (Integer integer : entrySet) {
            if (integer < 0) {
                if (!occurrence.get(integer).equals(occurrence.get(Math.abs(integer)))) {
                    return false;
                }
            }
            if (integer > 0) {
                if (!occurrence.get(integer).equals(occurrence.get(-(integer)))) {
                    return false;
                }
            }
        }
        if (occurrence.isEmpty()) {
            return true;
        }
        return isBalanced;
    }


}
