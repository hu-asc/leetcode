package com.code.problem_26;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesTest {


    @Test
    public void test() {
        RemoveDuplicates solution = new RemoveDuplicates();
        int[] nums = new int[]{1, 1, 2};
        int result = 2;
        Assert.assertEquals(result, solution.removeDuplicates(nums));
    }
}
