package com.code.problemset.problem_2466;

import java.util.Arrays;

public class CountGoodStrings {


    /**
     *
     * dfs(i) 表示构造长为 i 的字符串的总方案数
     *
     * dfs(i) = dfs(i - zero) + dfs(i - one)
     * @param low
     * @param high
     * @param zero
     * @param one
     * @return
     */
    public int countGoodStrings(int low, int high, int zero, int one) {
        int MOD = 1_000_000_007;
        int ans = 0;
        for (int i = low; i <= high; i++) {
            ans += dfs(i, zero, one);
        }
        return ans % MOD;
    }

    private int dfs(int len, int zero, int one) {
        if (len < 0) {
            return 0;
        }
        if (len == 0) {
            return 1;
        }
        int res = dfs(len - zero, zero, one) + dfs(len - one, zero, one);
        return res;
    }

    public int countGoodStringsV2(int low, int high, int zero, int one) {
        int MOD = 1_000_000_007;
        int[] memo = new int[high + 1];
        Arrays.fill(memo, -1);
        int ans = 0;
        for (int i = low; i <= high; i++) {
            ans += dfs(i, zero, one, memo);
        }
        return ans % MOD;
    }


    private int dfs(int len, int zero, int one, int[] memo) {
        if (len < 0) {
            return 0;
        }
        if (len == 0) {
            return 1;
        }
        if (memo[len] != -1) {
            return memo[len];
        }
        int res = dfs(len - zero, zero, one, memo) + dfs(len - one, zero, one, memo);
        memo[len] = res;
        return res;
    }


    /**
     * dp[i] = dp[i - zero] + dp[i - one]
     * @param low
     * @param high
     * @param zero
     * @param one
     * @return
     */
    public int countGoodStringsV3(int low, int high, int zero, int one) {
        int MOD = 1_000_000_007;
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] = (dp[i] + dp[i - zero]) % MOD;
            }
            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % MOD;
            }
            if (i >= low) {
                ans = (ans + dp[i]) % MOD;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        CountGoodStrings countGoodStrings = new CountGoodStrings();
        int low = 2;
        int high = 3;
        int zero = 1;
        int one = 2;
        System.out.println(countGoodStrings.countGoodStrings(low, high, zero, one));
        System.out.println(countGoodStrings.countGoodStringsV2(low, high, zero, one));
        System.out.println(countGoodStrings.countGoodStringsV3(low, high, zero, one));
    }
}
