package Amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sonnguyen on 3/18/18.
 */
public class MaximumSizeSubarraySumEqualsK {

    /**
     * Given an array nums and a target value k, find the maximum length
     * of a subarray that sums to k. If there isn't one, return 0 instead.
     * <p>
     * Note:
     * The sum of the entire nums array is guaranteed to fit within
     * the 32-bit signed integer range.
     * <p>
     * Example 1:
     * Given nums = [1, -1, 5, -2, 3], k = 3,
     * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
     * <p>
     * Example 2:
     * Given nums = [-2, -1, 2, 1], k = 1,
     * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
     * <p>
     * Follow Up:
     * Can you do it in O(n) time?
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, 5, -2, 3};
        System.out.println(maxSubArrayLen(nums, 3));

        nums = new int[]{-2, -1, 2, 1};
        System.out.println(maxSubArrayLen(nums, 1));
    }

    /**
     * The HashMap stores the sum of all elements before index i as key, and i as value.
     * For each i, check not only the current sum but also (currentSum - previousSum)
     * to see if there is any that equals k, and update max length.
     */
    private static int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k) max = i + 1;
            else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }
}
