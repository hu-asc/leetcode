package com.code.contest.weekly.contest_376;

import org.junit.Assert;
import org.junit.Test;

public class TestContest {

    @Test
    public void testMinimumCost() {
        MinimumCost minimumCost = new MinimumCost();

        int[] nums = {1,2,3,4,5};
        long result = 6;
        Assert.assertEquals(result, minimumCost.minimumCost(nums));


        nums = new int[]{10,12,13,14,15};
        result = 11;
        Assert.assertEquals(result, minimumCost.minimumCost(nums));

        nums = new int[]{22,33,22,33,22};
        result = 22;
        Assert.assertEquals(result, minimumCost.minimumCost(nums));


    }
}
