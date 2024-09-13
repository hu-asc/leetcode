package com.code.problemset.problem_239;

import org.junit.Assert;
import org.junit.Test;

public class MaxSlidingWindowTest {

    @Test
    public void test() {
        MaxSlidingWindow solution = new MaxSlidingWindow();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = new int[]{3, 3, 5, 5, 6, 7};
        Assert.assertArrayEquals(result, solution.maxSlidingWindow(nums, k));
        Assert.assertArrayEquals(result, solution.maxSlidingWindowV2(nums, k));
    }
}
