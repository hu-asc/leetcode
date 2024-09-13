package com.code.problemset.problem_3186;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumTotalDamage {


    /**
     * 先统计数字出现次数 count
     *
     * dfs(i) 表示使用 nums[0] 到 nums[i - 1] 造成的伤害和的最大值
     *
     * 不选 i, 则 dfs(i) = dfs(i - 1)
     * 选 i, 则 nums[i - 1] 和 nums[i - 2] 不能选, dfs(i) = dfs(j - 1) + cns[nums[i]) * nums[i]), j 是最小的满足 nums[j] >= nums[i] - 2
     *
     * dfs(i) = max(dfs(i - 1), dfs(j - 1) + cnt[nums[i]] * nums[i])
     *
     * @param power
     * @return
     */
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i : power) {
            cnt.merge(i, 1, Integer::sum);
        }
        int n = cnt.size();
        int[] a = new int[n];
        int k = 0;
        for (Integer x : cnt.keySet()) {
            a[k++] = x;
        }
        Arrays.sort(a);
        long[] memo = new long[n];
        Arrays.fill(memo, -1);
        return dfs(a, cnt, memo, n - 1);
    }

    private long dfs(int[] a, Map<Integer, Integer> cnt, long[] memo, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int x = a[i];
        int j = i;
        while (j > 0 && a[j - 1] >= x - 2) {
            j --;
        }

        memo[i] = Math.max(dfs(a, cnt, memo, i - 1), dfs(a, cnt, memo, j - 1) + a[i] * cnt.get(a[i]));
        return memo[i];
    }


    public static void main(String[] args) {
        int[] array = {7,1,6,6};
        MaximumTotalDamage maximumTotalDamage = new MaximumTotalDamage();
        System.out.println(maximumTotalDamage.maximumTotalDamage(array));

    }


}
