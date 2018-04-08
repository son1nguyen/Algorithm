package Easy;

/**
 * Created by sonnguyen on 4/8/18.
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * Given a sorted array, remove the duplicates in-place such that
     * each element appear only once and return the new length.
     * <p>
     * Do not allocate extra space for another array, you must do this by
     * modifying the input array in-place with O(1) extra memory.
     * <p>
     * Example:
     * <p>
     * Given nums = [1,1,2],
     * <p>
     * Your function should return length = 2, with the first two elements
     * of nums being 1 and 2 respectively.
     * It doesn't matter what you leave beyond the new length.
     */
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
    }

    private static int removeDuplicates(int[] nums) {
        int curr = 0, runner = 1;
        while (runner < nums.length) {
            if (nums[curr] != nums[runner]) {
                nums[++curr] = nums[runner];
            }
            runner++;
        }
        return ++curr;
    }
}
