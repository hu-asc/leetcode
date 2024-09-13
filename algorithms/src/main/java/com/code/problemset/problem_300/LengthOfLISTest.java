package com.code.problemset.problem_300;

import org.junit.Assert;
import org.junit.Test;

public class LengthOfLISTest {

    @Test
    public void test() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int result = 4;
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        Assert.assertEquals(result, lengthOfLIS.lengthOfLIS(nums));

        nums = new int[]{0, 1, 0, 3, 2, 3};
        result = 4;
        Assert.assertEquals(result, lengthOfLIS.lengthOfLIS(nums));

        nums = new int[]{7, 7, 7, 7, 7, 7, 7};
        result = 1;
        Assert.assertEquals(result, lengthOfLIS.lengthOfLIS(nums));
    }
}
