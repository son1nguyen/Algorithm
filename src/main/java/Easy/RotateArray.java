package Easy;

import java.util.Arrays;

/**
 * Created by sonnguyen on 4/8/18.
 */
public class RotateArray {

    /**
     * Rotate an array of n elements to the right by k steps.
     * <p>
     * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7]
     * is rotated to [5,6,7,1,2,3,4].
     * <p>
     * Note:
     * Try to come up as many solutions as you can, there are at
     * least 3 different ways to solve this problem.
     * <p>
     * [show hint]
     * <p>
     * Hint:
     * Could you do it in-place with O(1) extra space?
     * Related problem: Reverse Words in a String II
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        rotate(nums, 2);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * For example we have an array [1, 2, 3, 4, 5, 6, 7] and k = 3 => [5, 6, 7, 1, 2, 3, 4]
     * 1st: reverse the whole array [7, 6, 5, 4, 3, 2, 1]
     * 2nd: reverse the array from 0 -> 2 (inclusive) [5, 6, 7, 4, 3, 2, 1]
     * 3rd: reverse the array from 3 -> 7 (inclusive) [5, 6, 7, 1, 2, 3, 4]
     */
    private static void rotate(int[] nums, int k) {
        if (k == 0 || nums.length == 0) return;
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, k - 1);
    }

    private static void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int tmp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = tmp;

            startIndex++;
            endIndex--;
        }
    }
}
