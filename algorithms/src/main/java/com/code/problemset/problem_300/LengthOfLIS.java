package com.code.problemset.problem_300;


public class LengthOfLIS {

    /**
     * dp[i]表示以下标 i 结尾的最长递增子序列的长度
     * dp[i] = max(dp[j]) + 1, 0 <= j < i 且 nums[j] < num[i]
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

}
