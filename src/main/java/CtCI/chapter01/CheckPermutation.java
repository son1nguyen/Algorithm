package CtCI.chapter01;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by sonnguyen on 2/26/17.
 */
public class CheckPermutation {

    public static void main(String[] args) {
        System.out.println(sortingSolution("abc", "bca"));
        System.out.println(sortingSolution("aaa", "aab"));
        System.out.println(sortingSolution(null, "a"));
    }

    public static boolean sortingSolution(String s1, String s2) {
        if (s1 == null && s2 == null) return true;
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);

        for (int i = 0; i < s1Arr.length; i++) {
            if (s1Arr[i] != s2Arr[i]) {
                return false;
            }
        }
        return true;
    }
}
