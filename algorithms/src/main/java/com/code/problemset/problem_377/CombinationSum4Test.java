package com.code.problemset.problem_377;

import org.junit.Assert;

public class CombinationSum4Test {

    public static void main(String[] args) {
        CombinationSum4 combinationSum4 = new CombinationSum4();

        int[] nums = {1, 2, 3};
        int target = 4;
        int result = 7;

        Assert.assertEquals(result, combinationSum4.combinationSum4(nums, target));
        Assert.assertEquals(result, combinationSum4.combinationSum4V2(nums, target));
        Assert.assertEquals(result, combinationSum4.combinationSum4V3(nums, target));
    }
}
