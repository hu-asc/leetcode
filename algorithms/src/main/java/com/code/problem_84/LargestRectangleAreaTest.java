package com.code.problem_84;

import org.junit.Assert;
import org.junit.Test;

public class LargestRectangleAreaTest {

    @Test
    public void test() {
        LargestRectangleArea solution = new LargestRectangleArea();
        int[] height = new int[]{2, 1, 5, 6, 2, 3};
        int result = 10;
        Assert.assertEquals(result, solution.largestRectangleArea(height));
        Assert.assertEquals(result, solution.largestRectangleAreaV2(height));
    }
}
