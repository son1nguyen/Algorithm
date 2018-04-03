package Amazon;

/**
 * Created by sonnguyen on 3/18/18.
 */
public class ReverseWordsInAStringII {

    /**
     * Given an input string, reverse the string word by word.
     * A word is defined as a sequence of non-space characters.
     * <p>
     * The input string does not contain leading or trailing
     * spaces and the words are always separated by a single space.
     * <p>
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the".
     * <p>
     * Could you do it in-place without allocating extra space?
     * <p>
     * Related problem: Rotate Array
     * <p>
     * Update (2017-10-16):
     * We have updated the function signature to accept a character
     * array, so please reset to the default code definition by clicking
     * on the reload button above the code editor. Also, Run Code is now available!
     */
    public static void main(String[] args) {
        char[] str = "the sky is blue".toCharArray();
        reverseWords(str);
        System.out.println(str);
    }

    private static void reverseWords(char[] s) {
        // Three step to reverse
        // 1, reverse the whole sentence
        reverse(s, 0, s.length - 1);


        // 2, reverse each word
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }

        // 3, reverse the last word, if there is only one word this will solve the corner case
        reverse(s, start, s.length - 1);
    }

    private static void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
