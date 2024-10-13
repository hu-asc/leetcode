package com.code.problemset.problem_632;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author huhongtao
 * @date 2024-10-13
 */
public class SmallestRangeTest {


    @Test
    public void test() {
        SmallestRange smallestRange = new SmallestRange();
        List<List<Integer>> nums = Arrays.asList(
                Arrays.asList(4, 10, 15, 24, 26),
                Arrays.asList(0, 9, 12, 20),
                Arrays.asList(5, 18, 22, 30)
        );
        int[] expected = new int[]{20,24};

        // [[1,2,3],[1,2,3],[1,2,3]]
        int[] result = smallestRange.smallestRange(nums);
        Assert.assertArrayEquals(expected, result);
        result = smallestRange.smallestRangeV2(nums);
        Assert.assertArrayEquals(expected, result);

        nums = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(1,2,3),
                Arrays.asList(1,2,3)
        );
        expected = new int[]{1,1};
        result = smallestRange.smallestRange(nums);
        Assert.assertArrayEquals(expected, result);
        result = smallestRange.smallestRangeV2(nums);
        Assert.assertArrayEquals(expected, result);
    }

}
