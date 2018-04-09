package Easy;

/**
 * Created by sonnguyen on 4/8/18.
 */
public class ValidPalindrome {

    /**
     * Given a string, determine if it is a palindrome, considering only
     * alphanumeric characters and ignoring cases.
     * <p>
     * For example,
     * "A man, a plan, a canal: Panama" is a palindrome.
     * "race a car" is not a palindrome.
     * <p>
     * Note:
     * Have you consider that the string might be empty? This is a good
     * question to ask during an interview.
     * <p>
     * For the purpose of this problem, we define empty string as valid palindrome.
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

    private static boolean isPalindrome(String s) {
        int startIndex = findNext(s, 0, true);
        int endIndex = findNext(s, s.length() - 1, false);

        while (startIndex < endIndex) {
            if (Character.toLowerCase(s.charAt(startIndex)) != Character.toLowerCase(s.charAt(endIndex))) return false;
            startIndex = findNext(s, startIndex + 1, true);
            endIndex = findNext(s, endIndex - 1, false);
        }

        return true;
    }

    /**
     * @param s         the string itself
     * @param index     starting index, inclusive
     * @param direction true to go right, false to go left
     */
    private static int findNext(String s, int index, boolean direction) {
        if (direction) {
            for (int i = index; i < s.length(); i++) {
                if (Character.isLetterOrDigit(s.charAt(i))) return i;
            }
        } else {
            for (int i = index; i >= 0; i--) {
                if (Character.isLetterOrDigit(s.charAt(i))) return i;
            }
        }
        return -1;
    }
}
