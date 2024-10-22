package com.code.problemset.problem_39;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author huhongtao
 * @date 2024-10-22
 */
public class CombinationSumTest {

    @Test
    public void test() {
        CombinationSum combinationSum = new CombinationSum();

        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2,2,3),
                Arrays.asList(7)
        );
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);
        Assert.assertEquals(expected, result);
        result = combinationSum.combinationSumV2(candidates, target);
        Assert.assertEquals(expected, result);
    }
}
