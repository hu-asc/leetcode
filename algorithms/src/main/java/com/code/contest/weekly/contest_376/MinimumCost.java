package com.code.contest.weekly.contest_376;

import java.util.Arrays;

public class MinimumCost {

    /**
     * 给定一个数组nums,取数组的中位数到数组中的所有数的距离之和是最小的
     *
     * 1. 先预处理 10^9 的所有回文数
     * 2. 二分查找离得 nums 中位数最近的回文数，左右两侧都要进行查找，作为要变成的数字
     *
     * @param nums
     * @return
     */
    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int i = search(nums[(n - 1) / 2]);
        if (pal[i] <= nums[n / 2]) {
            return getCost(nums, i); // 直接变成 pal[i]
        }
        return Math.min(getCost(nums, i - 1), getCost(nums, i));
    }

    private int search(int target) {
        int l = 0, r = pal.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (pal[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


    private long getCost(int[] nums, int i) {
        int target = pal[i];
        long sum = Arrays.stream(nums).mapToLong(x -> Math.abs(x - target)).sum();
        return sum;
    }


    private static final int[] pal = new int[109999];

    static {
        int palIdx = 0;
        for (int base = 1; base <= 10000; base *= 10) {
            // 生成奇数长度的回文数
            for (int i = base; i < base * 10; i++) {
                int x = i;
                for (int t = i / 10; t > 0; t /= 10) {
                    x = x * 10 + t % 10;
                }
                pal[palIdx++] = x; // pal[i]
            }
            // 生成偶数长度的回文数
            if (base <= 1000) {
                for (int i = base; i < base * 10; i++) {
                    int x = i;
                    for (int t = i; t > 0; t /= 10) {
                        x = x * 10 + t % 10;
                    }
                    pal[palIdx++] = x; // pal[i]
                }
            }
        }
        pal[palIdx++] = 1_000_000_001;
    }

}
