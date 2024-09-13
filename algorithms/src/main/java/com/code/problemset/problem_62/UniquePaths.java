package com.code.problemset.problem_62;

import java.util.Arrays;

public class UniquePaths {

    /**
     * 递归
     * 可以缓存结果进行优化
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    /**
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsV2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    /**
     * 只需要保留dp[i - 1][j], dp[i][j - 1]两个值即可
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsV3(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }

}
