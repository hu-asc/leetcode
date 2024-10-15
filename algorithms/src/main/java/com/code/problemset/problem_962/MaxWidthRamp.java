package com.code.problemset.problem_962;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author huhongtao
 * @date 2024-10-10
 */
public class MaxWidthRamp {

    /**
     * 暴力方法：（超时）
     * 判断每个元素符合条件的最长宽度，取最大值
     *
     * 单调栈：
     * 从 0 开始找递减序列，将下标入栈
     * 逆序遍历数组，如果栈顶元素小于当前元素，则出栈，并更新宽度
     */
    public int maxWidthRamp(int[] nums) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            // 这里不用 >=，是因为两个数相同，j - i 最大，则 i 取最左边的
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                Integer pop = stack.pop();
                max = Math.max(max, i - pop);
            }
        }
        return max;
    }


    /**
     * 排序
     * 将 nums 按照值大小排序，将下标森放入新数组
     *
     * 遍历新数组，更新最大宽度和最小下标
     */
    public int maxWidthRampV2(int[] nums) {
        Integer[] indexArray = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexArray[i] = i;
        }
        Arrays.sort(indexArray, (o1, o2) -> ((Integer)nums[o1]).compareTo((Integer)nums[o2]));

        int max = 0;
        int minIndex = nums.length;
        for (Integer i : indexArray) {
            max = Math.max(max, i - minIndex);
            minIndex = Math.min(minIndex, i);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxWidthRamp maxWidthRamp = new MaxWidthRamp();
        int[] nums = new int[]{6,0,8,2,1,5};
        int i = maxWidthRamp.maxWidthRamp(nums);
        System.out.println(i);
        i = maxWidthRamp.maxWidthRampV2(nums);
        System.out.println(i);

        nums = new int[]{9,8,1,0,1,9,4,0,4,1};
        i = maxWidthRamp.maxWidthRamp(nums);
        System.out.println(i);
        i = maxWidthRamp.maxWidthRampV2(nums);
        System.out.println(i);
    }
}
