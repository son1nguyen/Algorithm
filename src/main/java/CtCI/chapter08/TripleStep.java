package CtCI.chapter08;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sonnguyen on 3/7/17.
 */
public class TripleStep {

    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(countWays(22) + " = " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        System.out.println(countWaysDynamically(22) + " = " + (System.currentTimeMillis() - start) + " ms");
    }

    private static int countWays(int steps) {
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        }

        return countWays(steps - 1) +
                countWays(steps - 2) +
                countWays(steps - 3);
    }

    private static int countWaysDynamically(int steps) {
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        }

        if (map.containsKey(steps)) {
            return map.get(steps);
        } else {
            int count = countWays(steps - 1) +
                    countWays(steps - 2) +
                    countWays(steps - 3);
            map.put(steps, count);
            return count;
        }
    }
}
