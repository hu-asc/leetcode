package com.code.problemset.problem_2530;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-15
 */
public class MaxKelementsTest {

    @Test
    public void test() {
        MaxKelements maxKelements = new MaxKelements();

        int[] nums = new int[]{10,10,10,10,10};
        int k = 5;
        long result = maxKelements.maxKelements(nums, k);
        long expected = 50;
        Assert.assertEquals(expected, result);

        nums = new int[]{1,10,3,3,3};
        k = 3;
        expected = 17;
        result = maxKelements.maxKelements(nums, k);
        Assert.assertEquals(expected, result);
    }
}
