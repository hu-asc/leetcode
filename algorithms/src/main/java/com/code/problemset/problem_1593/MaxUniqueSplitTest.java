package com.code.problemset.problem_1593;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-21
 */
public class MaxUniqueSplitTest {

    @Test
    public void test() {
        MaxUniqueSplit maxUniqueSplit = new MaxUniqueSplit();

        String s = "ababccc";
        int expected = 5;
        int result = maxUniqueSplit.maxUniqueSplit(s);
        Assert.assertEquals(expected, result);
        result = maxUniqueSplit.maxUniqueSplitV2(s);
        Assert.assertEquals(expected, result);

        s = "aba";
        expected = 2;
        result = maxUniqueSplit.maxUniqueSplit(s);
        Assert.assertEquals(expected, result);
        result = maxUniqueSplit.maxUniqueSplit(s);
        Assert.assertEquals(expected, result);
    }
}
