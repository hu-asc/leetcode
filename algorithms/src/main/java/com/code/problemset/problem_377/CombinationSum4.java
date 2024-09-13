package com.code.problemset.problem_377;

import java.util.Arrays;

public class CombinationSum4 {


    /**
     * dfs(i) 表示爬 i 个台阶的总方案数
     * 如果最后一步爬了 x = nums[j] 个台阶，问题变为爬 i - x 个台阶的方案数，即 dfs(i - x)
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        return dfs(target, nums);
    }

    private int dfs(int target, int[] nums) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int num : nums) {
            if (num <= target) {
                res += dfs(target - num, nums);
            }
        }
        return res;
    }


    public int combinationSum4V2(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return dfs(target, nums, memo);
    }

    private int dfs(int target, int[] nums, int[] memo) {
        if (target == 0) {
            return 1;
        }
        if (memo[target] != -1) {
            return memo[target];
        }
        int res = 0;
        for (int num : nums) {
            if (num <= target) {
                res += dfs(target - num, nums, memo);
            }
        }
        memo[target] = res;
        return memo[target];
    }


    /**
     * dp[i] = sum(dp[i - nums[j])
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4V3(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }



    public static void main(String[] args) {
        CombinationSum4 combinationSum4 = new CombinationSum4();

        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum4.combinationSum4(nums, target));
        System.out.println(combinationSum4.combinationSum4V2(nums, target));
        System.out.println(combinationSum4.combinationSum4V3(nums, target));
    }
}
