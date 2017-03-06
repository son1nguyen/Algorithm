package CtCI.chapter01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sonnguyen on 2/26/17.
 */

// Strings of an odd length must have exactly one character with an odd count.
// Strings with even length (afer removing all non-letter characters) must
// have all even counts of characters.
public class PalindromePermutation {

    public static void main(String[] args) {
        System.out.println(isPermutationOfPalindrome("tactc oapapa"));
    }

    public static boolean isPermutationOfPalindrome(String phrase) {
        if (phrase == null) return false;
        if (phrase.length() <= 1) return true;

        int[] checkList = new int[256];
        int countLength = 0;
        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);

            if (ch != ' ') {
                countLength++;
                checkList[(int) ch]++;
            }
        }

        int charThatAppearsOnce = 0;

        for (int i = 0; i < checkList.length; i++) {
            if (checkList[i] != 0 && checkList[i] % 2 != 0) {
                charThatAppearsOnce++;
            }
        }

        return charThatAppearsOnce == 0 || charThatAppearsOnce == 1;
    }
}
