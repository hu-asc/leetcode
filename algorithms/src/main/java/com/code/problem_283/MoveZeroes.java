package com.code.problem_283;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 */
public class MoveZeroes {

    /**
     * 非零值前移,后面补0
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int insertIndex = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertIndex++] = num;
            }
        }
        while (insertIndex < nums.length) {
            nums[insertIndex++] = 0;
        }
    }

    public void moveZeroesV2(int[] nums) {
        // 非零数位置
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

}
