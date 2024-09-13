package com.code.problemset.problem_1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TwoSumTest {

    @Test
    public void test() {
        TwoSum solution = new TwoSum();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result1 = new int[]{0, 1};
        int[] result2 = new int[]{1, 0};
        int[] v1 = solution.twoSum(nums, target);
        int[] v2 = solution.twoSumV2(nums, target);
        Assert.assertTrue(Arrays.equals(result1, v1) || Arrays.equals(result2, v1));
        Assert.assertTrue(Arrays.equals(result1, v2) || Arrays.equals(result2, v2));
    }

}
