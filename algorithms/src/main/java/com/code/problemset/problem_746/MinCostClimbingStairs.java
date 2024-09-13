package com.code.problemset.problem_746;

import java.util.Arrays;

public class MinCostClimbingStairs {


    /**
     * 如果最后一步爬了 1 个台阶，问题就变为从 0 到 i-1 台阶的最小花费：dfs(i) = dfs(i - 1) + cost[i - 1];
     * 如果最后一步爬了 2 个台阶，问题就变为从 0 到 i-2 台阶的最小花费：dfs(i) = dfs(i - 2) + cost[i - 2];
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return dfs(n, cost);
    }

    private int dfs(int i, int[] cost) {
        if (i <= 1) {
            return 0;
        }
        int a = dfs(i - 1, cost) + cost[i - 1];
        int b = dfs(i -2, cost) + cost[i -2];
        return Math.min(a, b);
    }

    /**
     * memo 数组的初始值一定不能等于要记忆化的值！例如初始值设置为 0，并且要记忆化的 dfs(i) 也等于 0，
     * 那就没法判断 0 到底表示第一次遇到这个状态，还是表示之前遇到过了，从而导致记忆化失效。一般把初始值设置为 −1。
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairsV2(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(n, memo, cost);
    }

    private int dfs(int i, int[] memo, int[] cost) {
        if (i <= 1) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int a = dfs(i - 1, memo, cost) + cost[i - 1];
        int b = dfs(i - 2, memo, cost) + cost[i - 2];
        memo[i] = Math.min(a, b);
        return memo[i];
    }


    /**
     * dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
     * @param cost
     * @return
     */
    public int minCostClimbingStairsV3(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    /**
     * 上一个状态 f1, 上上一个状态 f0
     * newF = min(f1 + cost[i - 1]), f0 + cost[i - 2])
     * @param cost
     * @return
     */
    public int minCostClimbingStairsV4(int[] cost) {
        int f0 = 0, f1 = 0;
        for (int i = 1; i < cost.length; i++) {
            int newF = Math.min(f1 + cost[i], f0 + cost[i - 1]);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }


}
