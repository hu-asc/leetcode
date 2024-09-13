package com.code.problemset.problem_189;

import org.junit.Assert;
import org.junit.Test;

public class RotateTest {

    @Test
    public void test() {
        Rotate solution = new Rotate();
        int[] nums = new int[]{1, 2, 3, 4};
        int k = 2;
        int[] result = new int[]{3, 4, 1, 2};
        solution.rotate(nums, k);
        Assert.assertArrayEquals(result, nums);
        nums = new int[]{1, 2, 3, 4};
        solution.rotateV2(nums, k);
        Assert.assertArrayEquals(result, nums);
    }
}

