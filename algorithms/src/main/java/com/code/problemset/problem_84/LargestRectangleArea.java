package com.code.problemset.problem_84;

import java.util.Stack;

/**
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 *
 * Constraints:
 * 1 <= heights.length <= 10^5
 * 0 <= heights[i] <= 10^4
 */
public class LargestRectangleArea {


    /**
     * 暴力法
     */
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                int area = (j - i + 1) * min;
                max = Math.max(max, area);
            }
        }
        return max;
    }

    /**
     * 遍历的元素比栈顶元素大，则入栈
     * 小的话，则说明以栈顶元素为高的最大面积即可得到
     * @param heights
     * @return
     */
    public int largestRectangleAreaV2(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i <= heights.length;) {
            int height = (i == heights.length ? 0 : heights[i]);
            if (stack.isEmpty() || height >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                // The width = index of right boundary - index of left boundary + 1 = (i - 1) - (stack.peek() + 1) + 1 = i - 1 - stack.peek().
                Integer currHeight = heights[stack.pop()];
                int rightBoundary = i - 1;
                int leftBoundary = stack.isEmpty() ? 0 : stack.peek() + 1;
                int width = rightBoundary - leftBoundary + 1;
                max = Math.max(max, currHeight * width);
            }
        }
        return max;
    }

}
