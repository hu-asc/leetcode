package com.code.problemset.problem_70;

import org.junit.Assert;
import org.junit.Test;

public class ClimbStairsTest {

    @Test
    public void test() {
        ClimbStairs solution = new ClimbStairs();
        int n = 2;
        int result = 2;
        Assert.assertTrue(result == solution.climbStairs(n));
        Assert.assertTrue(result == solution.climbStairsV2(n));
        Assert.assertTrue(result == solution.climbStairsV3(n));
        n = 4;
        result = 5;
        Assert.assertTrue(result == solution.climbStairs(n));
        Assert.assertTrue(result == solution.climbStairsV2(n));
        Assert.assertTrue(result == solution.climbStairsV3(n));
    }

}
