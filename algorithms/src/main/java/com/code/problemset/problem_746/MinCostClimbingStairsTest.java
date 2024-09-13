package com.code.problemset.problem_746;

import org.junit.Assert;
import org.junit.Test;

public class MinCostClimbingStairsTest {

    @Test
    public void test() {
        int[] cost = {10, 15, 20};
        int result = 15;
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        Assert.assertEquals(result, minCostClimbingStairs.minCostClimbingStairs(cost));
        Assert.assertEquals(result, minCostClimbingStairs.minCostClimbingStairsV2(cost));
        Assert.assertEquals(result, minCostClimbingStairs.minCostClimbingStairsV3(cost));
        Assert.assertEquals(result, minCostClimbingStairs.minCostClimbingStairsV4(cost));

        cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        result = 6;
        Assert.assertEquals(result, minCostClimbingStairs.minCostClimbingStairs(cost));
        Assert.assertEquals(result, minCostClimbingStairs.minCostClimbingStairsV2(cost));
        Assert.assertEquals(result, minCostClimbingStairs.minCostClimbingStairsV3(cost));
        Assert.assertEquals(result, minCostClimbingStairs.minCostClimbingStairsV4(cost));
    }

}
