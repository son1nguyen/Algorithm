package Amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sonnguyen on 3/5/18.
 */
public class FirstUniqueCharacterInAString {

    /**
     * Given a string, find the first non-repeating character in it and return it's index.
     * If it doesn't exist, return -1.
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
        System.out.println(firstUniqueChar("leetcode"));
        System.out.println(firstUniqueChar("loveleetcode"));
    }

    /**
     * Generic answer using HashMap to keep track of
     * frequency of each char
     */
    private static int firstUniqueChar(String s) {
        // Count the frequency of each char
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        // Find the first unique char in the string
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }

        return -1;
    }

    /**
     * Hey guys. My solution is pretty straightforward.
     * It takes O(n) and goes through the string twice:
     * <p>
     * Get the frequency of each character.
     * Get the first character that has a frequency of one.
     * Actually the code below passes all the cases. However,
     * according to @xietao0221, we could change the size of the
     * frequency array to 256 to store other kinds of characters.
     * Thanks for all the other comments and suggestions. Fight on!
     */
    private static int firstUniqueCharOptimal(String s) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
