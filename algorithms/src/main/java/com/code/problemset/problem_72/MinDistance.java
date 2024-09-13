package com.code.problemset.problem_72;

public class MinDistance {

    /**
     * dp[i][j]表示字符串 w1 从 0 到 i 和字符串 w2 从 0 到 j 的编辑距离
     * 如果最后一个字符相等则dp[i][j] = dp[i-1][j-1];
     * 如果最后一个字符不相等则dp[i][j] = min(dp[i-1][j-1] + 1, dp[i-1][j] + 1, dp[i][j-1] + 1)
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int lower = dp[i][j - 1] + 1;
                int leftLower = dp[i - 1][j - 1] + 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(left, Math.min(lower, leftLower));
                }
            }
        }
        return dp[m][n];
    }

}
