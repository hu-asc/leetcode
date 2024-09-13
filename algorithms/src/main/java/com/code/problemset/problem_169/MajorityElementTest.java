package com.code.problemset.problem_169;

import org.junit.Assert;
import org.junit.Test;

public class MajorityElementTest {

    @Test
    public void test() {
        MajorityElement solution = new MajorityElement();

        int[] nums = new int[]{2, 3, 3};
        int expectedResult = 3;

        int result = solution.majorityElement(nums);
        Assert.assertEquals(expectedResult, result);

        int resultV2 = solution.majorityElementV2(nums);
        Assert.assertEquals(expectedResult, resultV2);
    }
}
