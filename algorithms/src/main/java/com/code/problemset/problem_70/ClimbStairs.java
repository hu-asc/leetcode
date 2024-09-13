package com.code.problemset.problem_70;


/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Constraints: 1 <= n <= 45
 */
public class ClimbStairs {

    /**
     * Fibonacci数列（存在重复计算）
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    /**
     * 缓存计算结果
     */
    public int climbStairsV2(int n) {
        if (n <= 2) {
            return n;
        }
        int[] memo = new int[n];
        memo[0] = 1;
        memo[1] = 2;
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i - 2] + memo[i - 1];
        }
        return memo[n - 1];
    }


    /**
     * 保留最后的两个结果即可得到最终结果
     */
    public int climbStairsV3(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int total = 0;
        for (int i = 2; i < n; i++) {
            total = a + b;
            a = b;
            b = total;
        }
        return total;
    }
}
