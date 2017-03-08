package CtCI.chapter01;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sonnguyen on 2/26/17.
 */
public class ZeroMatrix {

    private static int[][] matrix = {
            {1, 0, 3, 4},
            {4, 5, 3, 5},
            {7, 8, 1, 9},
            {7, 8, 9, 9}};

    public static void main(String[] args) {
        setZeros();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setZeros() {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows.contains(i) || cols.contains(j)) matrix[i][j] = 0;
            }
        }
    }
}
