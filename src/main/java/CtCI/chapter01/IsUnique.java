package CtCI.chapter01;

/**
 * Created by sonnguyen on 2/26/17.
 */
public class IsUnique {

    public static void main(String[] args) {
        System.out.println(isUnique("abcderf"));
        System.out.println(isUnique("aabbcccccc"));
        System.out.println(isUnique("aaaaaaa"));
    }

    public static boolean isUnique(String s) {
        if (s.length() > 256) return false;

        boolean[] checkList = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            int charCode = s.charAt(i);
            if (checkList[charCode] == false) {
                checkList[charCode] = true;
            } else {
                return false;
            }
        }
        return true;
    }
}
