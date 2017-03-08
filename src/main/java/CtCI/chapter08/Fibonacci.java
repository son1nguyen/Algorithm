package CtCI.chapter08;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sonnguyen on 3/7/17.
 */
public class Fibonacci {

    private static Map<Integer, Integer> memorization = new HashMap<>();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fibonacci(40) + " = " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        System.out.println(fibonacciDynamically(40) + " = " + (System.currentTimeMillis() - start) + " ms");
    }

    private static int fibonacci(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        }

        return fibonacci(position - 1) + fibonacci(position - 2);
    }

    private static int fibonacciDynamically(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        }

        if (memorization.containsKey(position)) {
            return memorization.get(position);
        }

        int result = fibonacciDynamically(position - 1) +
                fibonacciDynamically(position - 2);
        memorization.put(position, result);
        return result;
    }
}
