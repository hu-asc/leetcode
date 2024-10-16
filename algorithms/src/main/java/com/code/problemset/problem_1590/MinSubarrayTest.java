package com.code.problemset.problem_1590;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-12
 */
public class MinSubarrayTest {

    @Test
    public void test() {
        MinSubarray minSubarray = new MinSubarray();

        int[] nums = new int[]{3,1,4,2};
        int p = 6;
        int expected = 1;
        int result = minSubarray.minSubarray(nums, p);
        Assert.assertEquals(expected, result);

        nums = new int[]{6,3,5,2};
        p = 9;
        expected = 2;
        result = minSubarray.minSubarray(nums, p);
        Assert.assertEquals(expected, result);

        nums = new int[]{1,2,3};
        p = 3;
        expected = 0;
        result = minSubarray.minSubarray(nums, p);
        Assert.assertEquals(expected, result);
    }
}
