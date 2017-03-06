package CtCI.chapter01;

import jdk.nashorn.internal.ir.ReturnNode;

/**
 * Created by sonnguyen on 2/26/17.
 */
public class OneAway {

    public static void main(String[] args) {
        System.out.println(isOneEditAway("pale", "ple"));
        System.out.println(isOneEditAway("pales", "pale"));
        System.out.println(isOneEditAway("pale", "bale"));
        System.out.println(isOneEditAway("pale", "bae"));
    }

    public static boolean isOneEditAway(String s1, String s2) {
        if (s1 == null && s2 == null) return true;
        if (s1 == null || s2 == null) return false;

        if (s1.length() == s2.length()) {
            int countDiff = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    countDiff++;
                }
            }
            return countDiff == 1;
        } else {
            int current = 0;

            while (current < s1.length() && current < s2.length()) {
                if (s1.charAt(current) != s2.charAt(current)) {
                    return (s1.length() < s2.length()) ?
                            s1.substring(0, current).equals(s2.substring(0, current)) &&
                                    s1.substring(current, s1.length()).equals(s2.substring(current + 1, s2.length()))
                            : s1.substring(0, current).equals(s2.substring(0, current)) &&
                            s1.substring(current + 1, s1.length()).equals(s2.substring(current, s2.length()));
                }

                current++;
            }
            return (s1.length() > s2.length()) ? s2.equals(s1.substring(0, s2.length())) :
                    s1.equals(s2.substring(0, s1.length()));
        }

    }
}
