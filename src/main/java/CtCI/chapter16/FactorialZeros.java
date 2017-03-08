package CtCI.chapter16;

import java.math.BigInteger;

/**
 * Created by sonnguyen on 2/27/17.
 */
public class FactorialZeros {

    public static void main(String[] args) {
        System.out.println(countZeros(999));
        BigInteger bigInteger = new BigInteger("1");
        for (int i = 1; i <= 999; i++) {
            bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
        }

        String result = bigInteger.toString();
        System.out.println(result.length());
        int numberZeros = 0;
        for (int i = result.length() - 1; i >= 0; i--) {
            if (result.charAt(i) == '0') {
                numberZeros++;
            } else {
                break;
            }
        }
        System.out.println("Number of zeros = " + numberZeros);

    }

    private static int countZeros(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            count += count5(i);
        }
        return count;
    }

    private static int count5(int num) {
        int count = 0;
        while (num % 5 == 0) {
            count++;
            num = num / 5;
        }

        return count;
    }
}
