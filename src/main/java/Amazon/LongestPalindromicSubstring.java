package Amazon;

/**
 * Created by sonnguyen on 3/19/18.
 */
public class LongestPalindromicSubstring {

    private int start, maxLength;

    /**
     * Given a string s, find the longest palindromic substring in s.
     * You may assume that the maximum length of s is 1000.
     * <p>
     * Example:
     * <p>
     * Input: "babad"
     * <p>
     * Output: "bab"
     * <p>
     * Note: "aba" is also a valid answer.
     * <p>
     * <p>
     * Example:
     * <p>
     * Input: "cbbd"
     * <p>
     * Output: "bb"
     */
    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("cbbd"));
    }

    private String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        for (int i = 0; i < s.length() - 1; i++) {
            expand(s, i, i); // assume odd length, try to extend Palindrome as possible
            expand(s, i, i + 1); // assume even length
        }

        return s.substring(start, start + maxLength);
    }

    private void expand(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        // Correct index position due to the nature of while loop
        start++;
        end--;

        if (maxLength < end - start + 1) {
            maxLength = end - start + 1;
            this.start = start;
        }
    }
}
