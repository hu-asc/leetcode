package com.code.problemset.problem_1405;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-16
 */
public class LongestDiverseStringTest {

    @Test
    public void test() {
        LongestDiverseString longestDiverseString = new LongestDiverseString();
        int a = 1;
        int b = 1;
        int c = 7;
        String result = longestDiverseString.longestDiverseString(a, b, c);
        String expected = "ccaccbcc";
        Assert.assertEquals(expected, result);

        result = longestDiverseString.longestDiverseStringV2(a, b, c);
        Assert.assertEquals(expected, result);

        a = 7;
        b = 1;
        c = 0;
        result = longestDiverseString.longestDiverseString(a, b, c);
        expected = "aabaa";
        Assert.assertEquals(expected, result);

        result = longestDiverseString.longestDiverseStringV2(a, b, c);
        Assert.assertEquals(expected, result);
    }
}
