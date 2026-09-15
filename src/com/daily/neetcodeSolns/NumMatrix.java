package com.daily.neetcodeSolns;

public class NumMatrix {
    int[][] parentMatrix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        parentMatrix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                parentMatrix[i][j] = matrix[i - 1][j - 1] + parentMatrix[i - 1][j] + parentMatrix[i][j - 1] - parentMatrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int complete = parentMatrix[row2 + 1][col2 + 1];
        int aboveArea = parentMatrix[row1][col2 + 1];
        int leftArea = parentMatrix[row2 + 1][col1];
        int overlap = parentMatrix[row1][col1];

        return complete - aboveArea - leftArea + overlap;
    }
}
