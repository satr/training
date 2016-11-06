package io.github.satr.training;

import java.util.Random;

public class MatrixHelper {
    public static int[][] createMatrix(int dimension) {
        Random random = new Random();
        int[][] matrix = new int[dimension][dimension];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = random.nextInt(50);
            }
        }
        return matrix;
    }

    public static void showMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%4d", matrix[j][i]);
            }
            System.out.println();
            System.out.println();
        }
    }
}
