package com.code.problemset.problem_2022;

/**
 * @author huhongtao
 * @date 2024-10-16
 */
public class Construct2DArray {

    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] result = new int[][]{};
        if (m * n != original.length) {
            return result;
        }
        result = new int[m][n];
        for (int i = 0; i < m; i++) {
            int[] value = new int[n];
            for (int j = 0; j < n; j++) {
                value[j] = original[i * n + j];
            }
            result[i] = value;
        }
        return result;
    }
}
