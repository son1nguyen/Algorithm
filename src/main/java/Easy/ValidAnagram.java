package Easy;

/**
 * Created by sonnguyen on 4/8/18.
 */
public class ValidAnagram {

    /**
     * Given two strings s and t, write a function to determine if t is an anagram of s.
     * <p>
     * For example,
     * s = "anagram", t = "nagaram", return true.
     * s = "rat", t = "car", return false.
     * <p>
     * Note:
     * You may assume the string contains only lowercase alphabets.
     * <p>
     * Follow up:
     * What if the inputs contain unicode characters?
     * How would you adapt your solution to such case?
     */
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    private static boolean isAnagram(String s, String t) {
        int[] alphabet = new int[256];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i)]++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i)]--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
