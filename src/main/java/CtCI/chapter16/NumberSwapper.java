package CtCI.chapter16;

/**
 * Created by sonnguyen on 2/26/17.
 */
public class NumberSwapper {

    public static void main(String[] args) {
        int a = 10;
        int b = 6;

        a = a - b;
        b = a + b;
        a = b - a;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
