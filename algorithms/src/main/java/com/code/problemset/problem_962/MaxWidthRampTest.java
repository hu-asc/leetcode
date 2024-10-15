package com.code.problemset.problem_962;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-15
 */
public class MaxWidthRampTest {

    @Test
    public void test() {
        MaxWidthRamp maxWidthRamp = new MaxWidthRamp();
        int[] nums = new int[]{6,0,8,2,1,5};
        int result = maxWidthRamp.maxWidthRamp(nums);
        int excepted = 4;
        Assert.assertEquals(excepted, result);

        result = maxWidthRamp.maxWidthRampV2(nums);
        Assert.assertEquals(excepted, result);

        nums = new int[]{9,8,1,0,1,9,4,0,4,1};
        excepted = 7;
        result = maxWidthRamp.maxWidthRamp(nums);
        Assert.assertEquals(excepted, result);

        result = maxWidthRamp.maxWidthRampV2(nums);
        Assert.assertEquals(excepted, result);
    }
}
