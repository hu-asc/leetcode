package com.code.contest.weekly.contest_375;

import java.util.*;

public class NumberOfGoodPartitions {


    /**
     * 1. 遍历数组，维护每个元素最后一次出现的下标
     * 2. 再次遍历数组，去合并区间
     *
     * @param nums
     * @return
     */
    public int numberOfGoodPartitions(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int ans = 0, maxRight = 0;
        for (int i = 0; i < nums.length; i++) {
            maxRight = Math.max(maxRight, map.get(nums[i]));
            if (maxRight == i) {
                // 当前区间合并完毕
                ans += 1;
            }
        }
        return (int) pow(2, ans - 1, 1_000_000_007);
    }

    private long pow(long x, int n, int mod) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = res * x % mod;
            }
            x = x * x % mod;
            n /= 2;
        }
        return res;
    }


    /**
     * 1.遍历数组，得到每个数字对应的区间
     * 2.排序
     * 3.判断区间是否可以合并，如果不能合并则此处可以理解为一个分割线，可以放置分割线也可以不放置分割线，所以数量为2的n次方
     * @param nums
     * @return
     */
    public int numberOfGoodPartitionsV2(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[1] = i;
            } else {
                map.put(nums[i], new int[]{i, i});
            }
        }
        List<int[]> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingInt(p -> p[0]));

        int count = 1;
        int maxRight = list.get(0)[1];
        for (int i = 1; i < list.size(); i++) {
            int left = list.get(i)[0];
            int right = list.get(i)[1];
            // 区间无法合并
            if (left > maxRight) {
                count = count * 2 % 1_000_000_007;
            }
            maxRight = Math.max(right, maxRight);
        }
        return count;
    }

}
