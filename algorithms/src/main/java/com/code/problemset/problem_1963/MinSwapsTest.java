package com.code.problemset.problem_1963;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-08
 */
public class MinSwapsTest {

    @Test
    public void test() {
        MinSwaps minSwaps = new MinSwaps();

        String s = "][][";
        int expected = 1;
        int result = minSwaps.minSwaps(s);
        Assert.assertEquals(expected, result);

        s = "]]][[[";
        expected = 2;
        result = minSwaps.minSwaps(s);
        Assert.assertEquals(expected, result);

        s = "[]";
        expected = 0;
        result = minSwaps.minSwaps(s);
        Assert.assertEquals(expected, result);
    }
}
