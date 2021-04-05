package com.code.problem_189;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * Constraints:
 * 1 <= nums.length <= 2 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^5
 */
public class Rotate {

    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }


    /**
     * 1 2 3 4 5
     * 5 4 3 2 1
     * 4 5 1 2 3
     *先翻转整个数组, 在翻转 0 到 k-1 和 k到nums.length - 1
     */
    public void rotateV2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

}
