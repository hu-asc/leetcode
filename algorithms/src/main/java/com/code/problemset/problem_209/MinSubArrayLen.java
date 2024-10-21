package com.code.problemset.problem_209;

/**
 * @author huhongtao
 * @date 2024-10-21
 */
public class MinSubArrayLen {

    /**
     * 暴力解法超时
     *
     * 滑动窗口
     *
     * 两个指针 left， right 分别指向字数组的开始和结束索引
     * 遍历 right，将元素添加到窗口，如果 sum >= target，则 left++，将元素移除窗口
     */
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0, right = 0, sum = 0;
        for (right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
