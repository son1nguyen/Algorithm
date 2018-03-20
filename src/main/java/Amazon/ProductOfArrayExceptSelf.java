package Amazon;

import java.util.Arrays;

/**
 * Created by sonnguyen on 3/20/18.
 */
public class ProductOfArrayExceptSelf {

    /**
     * Given an array of n integers where n > 1, nums, return an array output such
     * that output[i] is equal to the product of all the elements of nums except nums[i].
     * <p>
     * Solve it without division and in O(n).
     * <p>
     * For example, given [1,2,3,4], return [24,12,8,6].
     * <p>
     * Follow up:
     * Could you solve it with constant space complexity? (Note: The output array does
     * not count as extra space for the purpose of space complexity analysis.)
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    /**
     * Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array
     * except 4 is 2*3*5 which consists of two parts: left 2*3 and right 5. The product
     * is left*right. We can get lefts and rights:
     * <p>
     * Numbers:     2    3    4     5
     * Lefts:            2  2*3 2*3*4
     * Rights:  3*4*5  4*5    5
     * Let’s fill the empty with 1:
     * <p>
     * Numbers:     2    3    4     5
     * Lefts:       1    2  2*3 2*3*4
     * Rights:  3*4*5  4*5    5     1
     * We can calculate lefts and rights in 2 loops. The time complexity is O(n).
     * <p>
     * We store lefts in result array. If we allocate a new array for rights. The space
     * complexity is O(n). To make it O(1), we just need to store it in a variable which
     * is right in @lycjava3’s code.
     */
    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Calculate lefts and store in res
        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0)
                left = left * nums[i - 1];
            res[i] = left;
        }

        // Calculate rights and the product from the end of the array
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1)
                right = right * nums[i + 1];
            res[i] *= right;
        }
        return res;
    }
}
