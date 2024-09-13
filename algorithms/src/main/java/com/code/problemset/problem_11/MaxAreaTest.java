package com.code.problemset.problem_11;

import org.junit.Assert;
import org.junit.Test;

public class MaxAreaTest {

    @Test
    public void test() {
        MaxArea solution = new MaxArea();
        int[] height = new int[]{4, 3, 2, 1, 4};
        int result = 16;
        Assert.assertTrue(result == solution.maxArea(height));
        Assert.assertTrue(result == solution.maxAreaV2(height));
    }
}
