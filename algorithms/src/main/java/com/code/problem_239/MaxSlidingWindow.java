package com.code.problem_239;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 */
public class MaxSlidingWindow {

    /**
     * 暴力
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k  + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }
        return result;
    }


    /**
     * 遍历数组，保存可能的元素在双端队列
     * 1.窗口大小[i - k + 1, i]，如果队列的元素小于i - k + 1，则头部舍弃
     * 2.队列里小于nums[i]的元素从尾部舍弃
     * 3.队列的头部元素就是窗口的最大值
     */
    public int[] maxSlidingWindowV2(int[] nums, int k) {
        int[] result = new int[nums.length - k  + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[queue.peek()];
            }
        }
        return result;
    }

}
