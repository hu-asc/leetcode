package com.code.problemset.problem_2044;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-18
 */
public class CountMaxOrSubsetsTest {

    @Test
    public void test() {
        CountMaxOrSubsets countMaxOrSubsets = new CountMaxOrSubsets();
        int[] nums = new int[]{3,1};
        int expected = 2;
        int result = countMaxOrSubsets.countMaxOrSubsets(nums);
        Assert.assertEquals(expected, result);
        result = countMaxOrSubsets.countMaxOrSubsetsV2(nums);
        Assert.assertEquals(expected, result);
        result = countMaxOrSubsets.countMaxOrSubsetsV3(nums);
        Assert.assertEquals(expected, result);
        result = countMaxOrSubsets.countMaxOrSubsetsV4(nums);
        Assert.assertEquals(expected, result);

        nums = new int[]{2,2,2};
        expected = 7;
        result = countMaxOrSubsets.countMaxOrSubsets(nums);
        Assert.assertEquals(expected, result);
        result = countMaxOrSubsets.countMaxOrSubsetsV2(nums);
        Assert.assertEquals(expected, result);
        result = countMaxOrSubsets.countMaxOrSubsetsV3(nums);
        Assert.assertEquals(expected, result);
        result = countMaxOrSubsets.countMaxOrSubsetsV4(nums);
        Assert.assertEquals(expected, result);

        nums = new int[]{3,2,1,5};
        expected = 6;
        result = countMaxOrSubsets.countMaxOrSubsets(nums);
        Assert.assertEquals(expected, result);
        result = countMaxOrSubsets.countMaxOrSubsetsV2(nums);
        Assert.assertEquals(expected, result);
        result = countMaxOrSubsets.countMaxOrSubsetsV3(nums);
        Assert.assertEquals(expected, result);
        result = countMaxOrSubsets.countMaxOrSubsetsV4(nums);
        Assert.assertEquals(expected, result);
    }
}
