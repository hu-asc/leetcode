package com.code.problemset.problem_209;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-21
 */
public class MinSubArrayLenTest {

    @Test
    public void test() {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        int target = 7;
        int[] nums = new int[]{2,3,1,2,4,3};
        int expected = 2;
        int result = minSubArrayLen.minSubArrayLen(target, nums);
        Assert.assertEquals(expected, result);

        target = 4;
        nums = new int[]{1,4,4};
        expected = 1;
        result = minSubArrayLen.minSubArrayLen(target, nums);
        Assert.assertEquals(expected, result);

        target = 11;
        nums = new int[]{1,1,1,1,1,1,1,1};
        expected = 0;
        result = minSubArrayLen.minSubArrayLen(target, nums);
        Assert.assertEquals(expected, result);
    }

}
