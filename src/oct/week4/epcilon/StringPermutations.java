package oct.week4.epcilon;

/**
 * @author prakashponali
 * @Date 27/10/23
 */
public class StringPermutations {
    public static void main(String[] args) {
        String input = "prakash"; // Change this to your desired string
        permute(input, 0, input.length() - 1);
    }

    public static void permute(String str, int left, int right) {
        if (left == right) {
            System.out.println(str);
        } else {
            for (int i = left; i <= right; i++) {
                str = swap(str, left, i);
                permute(str, left + 1, right);
                str = swap(str, left, i); // Backtrack
            }
        }
    }

    public static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}

