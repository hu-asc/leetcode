package com.code.problem_15;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ThreeSumTest {

    @Test
    public void test() {
        ThreeSum solution = new ThreeSum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result1 = solution.threeSum(nums);
        List<List<Integer>> result2 = solution.threeSumV2(nums);
        List<List<Integer>> result3 = solution.threeSumV3(nums);
        Assert.assertEquals(result1, result2);
        Assert.assertEquals(result2, result3);
    }
}
