package com.code.problemset.problem_2044;

/**
 * @author huhongtao
 * @date 2024-10-18
 */
public class CountMaxOrSubsets {

    /**
     * 找到位或的最大值 maxValue
     * 然后使用递归生成所有的子集判断 currentOr 是否等于 maxValue
     * 如果相等，则记一次数
     */
    public int countMaxOrSubsets(int[] nums) {
        int maxValue = 0;
        for (int num : nums) {
            maxValue |= num;
        }
        return countSubsets(nums, 0, 0, maxValue);
    }

    private int countSubsets(int[] nums, int index, int currentOr, int maxValue) {
        if (index == nums.length) {
            return currentOr == maxValue ? 1 : 0;
        }
        // 不选择下标为 index 元素
        int count1 = countSubsets(nums, index + 1, currentOr , maxValue);
        // 选择下标为 index 元素
        int count2 = countSubsets(nums, index + 1, currentOr | nums[index], maxValue);
        return count1 + count2;
    }


    /**
     * 记忆化
     */
    public int countMaxOrSubsetsV2(int[] nums) {
        int maxValue = 0;
        for (int num : nums) {
            maxValue |= num;
        }
        int[][] memo = new int[nums.length][maxValue + 1];
        return countSubsets(nums, 0, 0, maxValue, memo);
    }

    private int countSubsets(int[] nums, int index, int currentOr, int maxValue, int[][] memo) {
        if (index == nums.length) {
            return currentOr == maxValue ? 1 : 0;
        }
        if (memo[index][currentOr] != 0) {
            return memo[index][currentOr];
        }
        // 不选择下标为 index 元素
        int count1 = countSubsets(nums, index + 1, currentOr , maxValue, memo);
        // 选择下标为 index 元素
        int count2 = countSubsets(nums, index + 1, currentOr | nums[index], maxValue, memo);
        return memo[index][currentOr] = count1 + count2;
    }


    /**
     * 位运算
     * nums.length < 16，可用整数的二进制来表示
     *
     * 判断是否选择第 j 位
     */
    public int countMaxOrSubsetsV3(int[] nums) {
        int maxValue = 0;
        for (int num : nums) {
            maxValue |= num;
        }
        // 子集总数
        int mask = 1 << nums.length;
        int count = 0;
        for (int i = 0; i < mask; i++) {
            int orVal = 0;
            for (int j = 0; j < nums.length; j++) {
                // 是否选择 i 的第 j 位，== 1 表示选择，需要做或运算
                if (((i >> j) & 1) == 1) {
                    orVal |= nums[j];
                } else {
                    // do nothing
                }
            }
            if (orVal == maxValue) {
                count++;
            }
        }
        return count;
    }


    /**
     * 动态规划
     * dp[i] 表示累计 or 值的子集的数量
     * dp[0] = 1 表示空子集
     * 填充 dp, 计算 num 与 (0 - 当前 max) 的所有 or , 并累加旧 dp[i]
     * dp[max] 就是最终结果
     */
    public int countMaxOrSubsetsV4(int[] nums) {
        int max = 0;
        // 数据最大为 10 的 5 次方，二进制为 17 位
        int[] dp = new int[1 << 17];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = max; i >= 0; i--) {
                dp[i | num] += dp[i];
            }
            max |= num;
        }
        return dp[max];
    }
}
