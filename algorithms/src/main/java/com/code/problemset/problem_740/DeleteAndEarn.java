package com.code.problemset.problem_740;

import java.util.Arrays;

public class DeleteAndEarn {


    /**
     * 先统计出每个数字出现的次数 count
     * dfs(i) 表示删除数字 i 获得的最大点数
     *
     * dfs(i) = max(dfs(i - 1), nums[i] * count + dfs(i - 2))
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            maxVal = Math.max(num, maxVal);
        }
        int[] cntArray = new int[maxVal + 1];
        for (int num : nums) {
            ++cntArray[num];
        }
        int ans = 0;
        for (int i = maxVal; i > 0; i--) {
            if (cntArray[i] != 0) {
                ans = Math.max(ans, dfs(i, cntArray));
            }
        }
        return ans;
    }

    private int dfs(int n, int[] cntArray) {
        if (n <= 0) {
            return 0;
        }
        if (cntArray[n] == 0) {
            return dfs(n - 1, cntArray);
        }
        int res = Math.max(dfs(n - 1, cntArray), cntArray[n] * n + dfs(n - 2, cntArray));
        return res;
    }


    /**
     *
     * @param nums
     * @return
     */
    public int deleteAndEarnV2(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            maxVal = Math.max(num, maxVal);
        }
        int[] cntArray = new int[maxVal + 1];
        for (int num : nums) {
            ++cntArray[num];
        }
        int[] memo = new int[maxVal + 1];
        Arrays.fill(memo, -1);
        int ans = 0;
        for (int i = maxVal; i > 0; i--) {
            if (cntArray[i] != 0) {
                ans = Math.max(ans, dfs(i, cntArray, memo));
            }
        }
        return ans;
    }

    private int dfs(int i, int[] cntArray, int[] memo) {
        if (i <= 0) {
            return 0;
        }
        if (cntArray[i] == 0) {
            return dfs(i - 1, cntArray, memo);
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int res = Math.max(dfs(i - 1, cntArray, memo), cntArray[i] * i + dfs(i - 2, cntArray, memo));
        memo[i] = res;
        return res;
    }


    /**
     *
     * dp[i] = max(dp[i - 1], dp[i -2] + nums[i] * count)
     * @param nums
     * @return
     */
    public int deleteAndEarnV3(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            maxVal = Math.max(num, maxVal);
        }
        int[] cntArray = new int[maxVal + 1];
        for (int num : nums) {
            ++cntArray[num];
        }
        System.out.println(Arrays.toString(cntArray));
        int ans = 0;
        int[] dp = new int[maxVal + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (cntArray[nums[i]] != 0) {
                dp[i] = Math.max(dp[i - 1], nums[i] * cntArray[nums[i]] + dp[i - 2]);
                ans = Math.max(ans, dp[i]);
            }

        }
        System.out.println(Arrays.toString(dp));
        return dp[maxVal];
    }


    public static void main(String[] args) {
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        int[] nums = {3};
        System.out.println(deleteAndEarn.deleteAndEarn(nums));
        System.out.println(deleteAndEarn.deleteAndEarnV2(nums));
        System.out.println(deleteAndEarn.deleteAndEarnV3(nums));
    }

}
