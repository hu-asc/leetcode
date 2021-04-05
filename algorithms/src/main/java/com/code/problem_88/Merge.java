package com.code.problem_88;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.
 *
 * Constraints:
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 */
public class Merge {

    /**
     * 比较两个数组元素, 较小者先放入数组, 继续向后遍历, 最后判断两个数组是否都遍历结束
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                nums[count++] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                nums[count++] = nums2[j++];
            }
        }
        while (i < m) {
            nums[count++] = nums1[i++];
        }
        while (j < n) {
            nums[count++] = nums2[j++];
        }
        System.arraycopy(nums, 0, nums1, 0, m + n);
    }

    /**
     * 数组有序, 数组1的长度为m+n,从后往前放元素，相比上面方法可以省一个数组
     */
    public void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

}
