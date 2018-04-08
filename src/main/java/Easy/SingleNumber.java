package Easy;

/**
 * Created by sonnguyen on 4/8/18.
 */
public class SingleNumber {

    /**
     * Given an array of integers, every element appears twice
     * except for one. Find that single one.
     * <p>
     * Note:
     * Your algorithm should have a linear runtime complexity.
     * Could you implement it without using extra memory?
     */
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 1, 3, 2, 2}));
    }

    /**
     * Known that A XOR A = 0 and the XOR operator is commutative,
     * the solution will be very straightforward.
     */
    private static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
