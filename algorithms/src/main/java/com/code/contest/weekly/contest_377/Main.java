package com.code.contest.weekly.contest_377;

import java.util.*;

public class Main {

    public int[] numberGame(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            int a = nums[i];
            int b = nums[i + 1];
            arr[i] = b;
            arr[i + 1] = a;
        }
        return arr;
    }

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        // 判断栅栏是否存在这样的数
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        long max = 0;
        // 需要判断m n
        for (int i = 0; i < hFences.length; i++) {
            int a = hFences[i] - 1;
            for (int j = 0; j < vFences.length; j++) {
                int b = vFences[j] - 1;
                if (a == b) {
                    max = Math.max(max, a * b);
                }
            }
        }

        if (max == 0) {
            return -1;
        }
        return (int) (max * max % (1e9 + 7));
    }


    /**
     *
     * dp[i][j]表示字符串 w1 从 0 到 i 和字符串 w2 从 0 到 j 的编辑距离
     * 如果最后一个字符相等则dp[i][j] = dp[i-1][j-1];
     * 如果最后一个字符不相等则dp[i][j] = min(dp[i-1][j-1] + 1, dp[i-1][j] + 1, dp[i][j-1] + 1)
     */
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] dp = new int[source.length() + 1][source.length() + 1];


        return 0;
    }


    public static void main(String[] args) {
        Main main = new Main();

        int[] array = {2, 5};
        int[] ints = main.numberGame(array);
        System.out.println(Arrays.toString(ints));
    }



}
