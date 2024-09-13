package com.code.problemset.problem_121;

public class MaxProfit {

    /**
     * dp[i][0]表示第 i 天不持股，拥有的现金数
     * dp[i][1]表示第 i 天持股，拥有的现金数
     * dp[i][0] = max(dp[i-1][0], prices[i] + dp[i-1][1])
     * dp[i][1] = max(dp[i-1][1], -prices[i])
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], prices[i] + dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }

}
