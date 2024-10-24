package com.code.problemset.problem_162;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-24
 */
public class FindPeakElementTest {

    @Test
    public void test() {
        FindPeakElement findPeakElement = new FindPeakElement();

        int[] nums = new int[]{1,2,3,1};
        int expected = 2;
        int result = findPeakElement.findPeakElement(nums);
        Assert.assertEquals(expected, result);

        nums = new int[]{1,2,1,3,5,6,4};
        expected = 5;
        result = findPeakElement.findPeakElement(nums);
        Assert.assertEquals(expected, result);
    }
}
