package com.code.contest.weekly.contest_375;

import java.util.ArrayList;
import java.util.List;

public class GetGoodIndices {

    /**
     * (a + b) mod m = ((a mod m) + (b mod m)) mod m
     * (a * b) mod m = ((a mod m) * (b mod m)) mod m
     * @param variables
     * @param target
     * @return
     */
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] array = variables[i];
            if (pow(pow(array[0], array[1], 10), array[2], array[3]) == target) {
                list.add(i);
            }
        }
        return list;
    }


    /**
     * 快速幂取模
     * x的n次方以mod取模
     * @param x
     * @param n
     * @param mod
     * @return
     */
    private long pow(long x, int n, int mod) {
        long res = 1;
        while (n > 0) {
            // 奇数乘以x一次
            if (n % 2 == 1) {
                res = res * x % mod;
            }
            x = x * x % mod;
            n /= 2;
        }
        return res;
    }
}
