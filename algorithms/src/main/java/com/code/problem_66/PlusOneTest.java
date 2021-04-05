package com.code.problem_66;

import org.junit.Assert;
import org.junit.Test;

public class PlusOneTest {

    @Test
    public void test() {
        PlusOne solution = new PlusOne();
        int[] digits = new int[]{1, 2, 3};
        int[] value = solution.plusOne(digits);
        int[] result = new int[]{1, 2, 4};
        Assert.assertArrayEquals(result, value);
        digits = new int[]{1, 2, 3};
        value = solution.plusOneV2(digits);
        Assert.assertArrayEquals(result, value);
    }
}
