package com.code.problemset.problem_121;

import org.junit.Assert;
import org.junit.Test;

public class MaxProfitTest {

    @Test
    public void test() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = 5;
        MaxProfit maxProfit = new MaxProfit();
        Assert.assertEquals(result, maxProfit.maxProfit(prices));
        prices = new int[]{7, 6, 4, 3, 1};
        result = 0;
        Assert.assertEquals(result, maxProfit.maxProfit(prices));
    }

}
