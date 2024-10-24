package com.code.problemset.problem_162;

/**
 * @author huhongtao
 * @date 2024-10-24
 */
public class FindPeakElement {

    /**
     * 由于 nums[-1] = nums[n] = -∞，所以峰顶元素一定存在
     * 二分查找
     *
     *
     * 红蓝染色法
     * 红色表示峰顶左侧 蓝色表示峰顶及峰顶右侧
     * n - 1 一定是蓝色，因为右侧没有元素了，所以查找范围是 [0, n - 2]
     *
     */
    public int findPeakElement(int[] nums) {
        int left = -1;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            // 下坡，所以峰顶元素在左侧
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
