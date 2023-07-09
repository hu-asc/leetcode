package com.code.problem_63;

public class UniquePathsWithObstacles {

    /**
     * 有障碍物则步数为0
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j ++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 只需要保留dp[i - 1][j], dp[i][j - 1]两个值
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstaclesV2(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int i = 0; i < n; i++) {
                if (row[i] == 1) {
                    dp[i] = 0;
                } else if (i > 0) {
                    dp[i] += dp[i - 1];
                }
            }
        }
        return dp[n - 1];
    }

}
