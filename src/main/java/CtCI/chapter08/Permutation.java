package CtCI.chapter08;

/**
 * Created by sonnguyen on 3/7/17.
 */
public class Permutation {

    public static void main(String[] args) {
        permutationWithoutDups("abc", 0);
    }

    private static void permutationWithoutDups(String s, int currentIndex) {
        if (currentIndex >= s.length()) return;

        String temp = s.charAt(currentIndex) + s.substring(0, currentIndex) +
                s.substring(currentIndex + 1, s.length());

        for (int i = 1; i < temp.length(); i++) {
            String result = swapChar(temp, 0, i);
            System.out.println(result);
        }

        permutationWithoutDups(s, currentIndex + 1);
    }

    private static void swapFirstLetterWithTheRest(String str) {
        for (int i = 1; i < str.length(); i++) {
            String result = swapChar(str, 0, i);
            System.out.println(result);
        }
    }

    private static String swapChar(String str, int index, int anotherIndex) {
        if (index == anotherIndex) {
            return str;
        } else if (index < anotherIndex) {
            return str.substring(0, index) +
                    str.charAt(anotherIndex) +
                    str.substring(index + 1, anotherIndex) +
                    str.charAt(index) +
                    str.substring(anotherIndex + 1, str.length());
        } else {
            return str.substring(0, anotherIndex) +
                    str.charAt(index) +
                    str.substring(anotherIndex + 1, index) +
                    str.charAt(anotherIndex) +
                    str.substring(index + 1, str.length());
        }
    }
}
