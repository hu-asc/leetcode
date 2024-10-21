package com.code.problemset.problem_2220;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-20
 */
public class MinBitFlipsTest {

    @Test
    public void test() {
        MinBitFlips minBitFlips = new MinBitFlips();

        int start = 10;
        int goal = 7;
        int expected = 3;
        int result = minBitFlips.minBitFlips(start, goal);
        Assert.assertEquals(expected, result);
        result = minBitFlips.minBitFlipsV2(start, goal);
        Assert.assertEquals(expected, result);
        result = minBitFlips.minBitFlipsV3(start, goal);
        Assert.assertEquals(expected, result);

        start = 3;
        goal = 4;
        expected = 3;
        result = minBitFlips.minBitFlips(start, goal);
        Assert.assertEquals(expected, result);
        result = minBitFlips.minBitFlipsV2(start, goal);
        Assert.assertEquals(expected, result);
        result = minBitFlips.minBitFlipsV3(start, goal);
        Assert.assertEquals(expected, result);
    }
}
