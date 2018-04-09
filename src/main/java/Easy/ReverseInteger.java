package Easy;

/**
 * Created by sonnguyen on 4/8/18.
 */
public class ReverseInteger {

    /**
     * Given a 32-bit signed integer, reverse digits of an integer.
     * <p>
     * Example 1:
     * <p>
     * Input: 123
     * Output:  321
     * Example 2:
     * <p>
     * Input: -123
     * Output: -321
     * Example 3:
     * <p>
     * Input: 120
     * Output: 21
     * Note:
     * Assume we are dealing with an environment which could only hold integers
     * within the 32-bit signed integer range. For the purpose of this problem,
     * assume that your function returns 0 when the reversed integer overflows.
     */
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));

        boolean[] checkList = new boolean[256];
        System.out.println(checkList[0]);
    }

    private static int reverse(int x) {
        // Negative cases
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) return 0;
        int num = (x < 0) ? x * -1 : x;

        int remainder = num % 10;
        int result = remainder;
        while ((num - remainder) / 10 != 0) {
            num = (num - remainder) / 10;
            remainder = num % 10;

            // In case the number is overflow
            if (Integer.MAX_VALUE / 10 < result) return 0;

            result = result * 10 + remainder;
        }
        return (x < 0) ? result * -1 : result;
    }
}
