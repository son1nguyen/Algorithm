package Easy;

/**
 * Created by sonnguyen on 4/8/18.
 */
public class FirstUniqueCharacterInAString {

    /**
     * Given a string, find the first non-repeating character in it and
     * return it's index. If it doesn't exist, return -1.
     * <p>
     * Examples:
     * <p>
     * s = "leetcode"
     * return 0.
     * <p>
     * s = "loveleetcode",
     * return 2.
     * Note: You may assume the string contain only lowercase letters.
     */
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }

    private static int firstUniqChar(String s) {
        // ASCII only has 256 characters
        int[] checkList = new int[256];

        // Count frequency
        for (int i = 0; i < s.length(); i++) {
            checkList[s.charAt(i)]++;
        }

        // Find 1st char with frequency of 1
        for (int i = 0; i < s.length(); i++) {
            if (checkList[s.charAt(i)] == 1) return i;
        }

        return -1;
    }
}
