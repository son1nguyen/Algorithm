package CtCI.chapter01;

/**
 * Created by sonnguyen on 3/14/17.
 */
public class RotateMatrix {

    private static int[][] matrix = {
            {1, 0, 3, 4},
            {4, 5, 3, 5},
            {7, 8, 1, 9},
            {7, 8, 9, 9}};

    public static void main(String[] args) {
        rotate();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotate() {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return;

        // The secret is to rotate layer by layer
        int layer = matrix.length / 2;
        int lengthIndex = matrix.length - 1;

        for (int i = 0; i < layer; i++) {
            for (int j = i; j < matrix.length - i - 1; j++) {
                int temp = matrix[i][j];

                matrix[i][j] = matrix[lengthIndex - j][i];
                matrix[lengthIndex - j][i] = matrix[lengthIndex - i][lengthIndex - j];
                matrix[lengthIndex - i][lengthIndex - j] = matrix[j][lengthIndex - i];
                matrix[j][lengthIndex - i] = temp;
            }
        }
    }
}
