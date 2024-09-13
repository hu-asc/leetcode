package com.code.contest.weekly.contest_375;

import java.util.Arrays;

public class CountSubarrays {


    /**
     * 1.右端点从左向右遍历，如果当前值等于最大值，则计数器加1，
     * 2.直到计数器等于k，此时左端点向右移动，直到窗口内的最大值出现的次数小于k为止，
     * 对于右端点为 right且左端点小于 left 的子数组，max的出现次数都至少为 k，把答案增加 left。
     * @param nums
     * @param k
     * @return
     */
    public long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int count = 0, left = 0;
        for (int num : nums) {
            if (num == max) {
                count++;
            }
            while (count == k) {
                if (nums[left++] == max) {
                    count--;
                }
            }
            ans += left;
        }
        return ans;
    }
}
