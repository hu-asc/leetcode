package com.code.problemset.problem_670;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-17
 */
public class MaximumSwapTest {

    @Test
    public void test() {
        MaximumSwap maximumSwap = new MaximumSwap();

        int num = 2736;
        int expected = 7236;
        int result = maximumSwap.maximumSwap(num);
        Assert.assertEquals(expected, result);
        result = maximumSwap.maximumSwapV2(num);
        Assert.assertEquals(expected, result);

        num = 9973;
        expected = 9973;
        result = maximumSwap.maximumSwap(num);
        Assert.assertEquals(expected, result);
        result = maximumSwap.maximumSwapV2(num);
        Assert.assertEquals(expected, result);
    }
}
