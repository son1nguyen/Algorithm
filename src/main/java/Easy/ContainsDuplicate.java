package Easy;

import java.util.Arrays;

/**
 * Created by sonnguyen on 4/8/18.
 */
public class ContainsDuplicate {

    /**
     * Given an array of integers, find if the array contains any duplicates.
     * Your function should return true if any value appears at least twice
     * in the array, and it should return false if every element is distinct.
     */
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4, 5, 3, 4, 6, 5, 6}));
        System.out.println(containsDuplicate(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }

    private static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
}
