package com.code.problemset.problem_2028;

import java.util.Arrays;

/**
 * @author huhongtao
 * @date 2024-10-18
 */
public class MissingRolls {

    /**
     * 基于数组 rolls，可得到 m 次总和
     * 根据平均数 mean 和 次数 n+m，可得到 m+n 次的总和
     * 由上可知，n 次的总和
     *
     * 边界：n 次总和不能小于 n 或者 不能大于 6n
     * 填充数组数据，可以填平均值
     */
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] result = new int[n];
        int mSum = 0;
        for (int roll : rolls) {
            mSum += roll;
        }
        int sum = (rolls.length + n) * mean;
        int bSum = sum - mSum;
        if (bSum < n || bSum > n * 6) {
            return new int[]{};
        }
        int avg = bSum / n;
        // 全部填充平均数
        Arrays.fill(result, avg);
        // 如果不能整除，则基于 mod 在将数字 + 1
        int mod = bSum % n;
        for (int i = 0; i < mod; i++) {
            result[i]++;
        }
        return result;
    }

}
