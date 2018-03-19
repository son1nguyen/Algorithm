package Amazon;

/**
 * Created by sonnguyen on 3/5/18.
 */
public class ReverseString {

    /**
     * Write a function that takes a string as input and returns the string reversed.
     * <p>
     * Example:
     * Given s = "hello", return "olleh".
     */
    public static void main(String[] args) {
        System.out.println(reverseString("Son Nguyen"));
        System.out.println(reverseString("Hello"));

        System.out.println(reverseStringLibrary("Son Nguyen"));
        System.out.println(reverseStringLibrary("Hello"));
    }

    private static String reverseString(String s) {
        StringBuffer buffer = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            buffer.append(s.charAt(i));
        }
        return buffer.toString();
    }

    private static String reverseStringLibrary(String s) {
        return new StringBuffer(s).reverse().toString();
    }
}