package com.code.contest.weekly.contest_376;

import java.util.*;

public class Main {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int a = 0;
        for (int[] array : grid) {
            for (int i : array) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }
        }
        map.entrySet().stream().filter(e -> e.getValue() == 2).forEach(e -> ans[0] = e.getKey());
        for (int i = 1; i <= grid.length * grid.length; i++) {
            if (!map.containsKey(i)) {
                ans[1] = i;
            }
        }
        return ans;
    }

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i = i + 3) {
            int min = nums[i];
            int max = nums[i + 2];
            if (max - min <= k) {
                list.add(new int[]{nums[i], nums[i + 1], nums[i + 2]});
            } else {
                return new int[0][];
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    /**
     * dp[i] = dp[i-1] + (nums[i] - y)
     * @param nums
     * @return
     */
    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        if (nums.length == 1) {
            return 0;
        }
        for (int i = 1; i < nums[nums.length - 1] * 10; i++) {
            // 判断回文数字
            if (check(i)) {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            return 0;
        }
        long min = Integer.MAX_VALUE;
        for (int num : list) {
            int y = num;
            long ans = 0;
            for (int i = 0; i < nums.length; i++) {
                ans += Math.abs(nums[i] - y);
            }
            min = Math.min(ans, min);
        }
        return min;
    }

    private boolean check(int num) {
        int temp = num;
        int reverse = 0;
        while (num > 0) {
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }
        if (temp == reverse) {
            return true;
        }
        return false;
    }


    /**
     * dp[i][j][k]表示第i个元素，操作第k次的的最大频率, j表示当前的众数
     *
     * dp[i][j][k] = dp[i-1][0][k] + 1
     *
     * dp[i][1] != 当前i
     * @param nums
     * @param k
     * @return
     */
    public int maxFrequencyScore(int[] nums, long k) {
        int[][][] dp = new int[nums.length][2][(int) k];
        for (int i = 0; i < nums.length; i++) {

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] ints = {206,215,216,219,220,221};
        System.out.println(new Main().minimumCost(ints));

    }

}
