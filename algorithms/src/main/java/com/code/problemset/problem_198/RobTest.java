package com.code.problemset.problem_198;

import org.junit.Assert;
import org.junit.Test;

public class RobTest {

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 1};
        int result = 4;
        Rob rob = new Rob();
        Assert.assertEquals(result, rob.rob(nums));
        Assert.assertEquals(result, rob.robV2(nums));

        nums = new int[]{2, 7, 9, 3, 1};
        result = 12;
        Assert.assertEquals(result, rob.rob(nums));
        Assert.assertEquals(result, rob.robV2(nums));
    }
}
