package com.code.problem_283;

import org.junit.Assert;
import org.junit.Test;

public class MoveZeroesTest {

    @Test
    public void test() {
        MoveZeroes solution = new MoveZeroes();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] result = new int[]{1, 3, 12, 0, 0};
        solution.moveZeroes(nums);
        Assert.assertArrayEquals(result, nums);
        nums = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroesV2(nums);
        Assert.assertArrayEquals(result, nums);
    }
}
