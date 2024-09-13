package com.code.problemset.problem_198;


public class Rob {


    public int rob1(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int i = 2; i < nums.length; i++) {
            int temp = dfs(nums, i);
            ans= Math.max(ans, temp);
        }
        return ans;
    }

    private int dfs(int[] nums, int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return Math.max(nums[0], nums[i]);
        }
        int ans = dfs(nums, i - 1);
        return ans;
    }

    /**
     * dp[i]表示偷 0 到 i 间房子的最大金额
     * 如果最后一个房子（i）没有被偷，则最大金额为 dp[i - 1]
     * 如果最后一个房子（i）被偷，则最大金金额为 dp[i - 2] + nums[i]
     * dp[i] = max(dp[i - 2] + nums[i], dp[i-1])
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return Math.max(nums[0], nums[nums.length - 1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }

    /**
     * dp[i][0]表示偷 0 到 i 间房子的最大金额且没偷 nums[i]
     * dp[i][1]表示偷 0 到 i 间房子的最大金额且偷了 nums[i]
     *
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1])
     * dp[i][1] = dp[i-1][0] + nums[i]
     * @param nums
     * @return
     */
    public int robV2(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }

}
