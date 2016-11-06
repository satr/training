package io.github.satr.training.matrix;

import io.github.satr.training.MatrixHelper;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = MatrixHelper.createMatrix(6);
        MatrixHelper.showMatrix(matrix);
        rotate(matrix);
        rotate(matrix);
        rotate(matrix);
        rotate(matrix);
        System.out.println("Result:");
        MatrixHelper.showMatrix(matrix);
    }

    private static void rotate(int[][] matrix) {
        for (int level = 0; level < matrix.length / 2; level++)
            rotate(matrix, level, matrix.length - 1 - level);
    }

    private static void rotate(int[][] matrix, int level, int maxInd) {
        for (int i = 0; level + i < maxInd; i++) {
            int tmp = matrix[level + i][level];
            matrix[level + i][level] = matrix[maxInd][level + i];
            matrix[maxInd][level + i] = matrix[maxInd - i][maxInd];
            matrix[maxInd - i][maxInd] = matrix[level][maxInd - i];
            matrix[level][maxInd - i] = tmp;
        }
    }
}
