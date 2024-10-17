package com.code.problemset.problem_1894;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-16
 */
public class ChalkReplacerTest {

    @Test
    public void test() {
        ChalkReplacer chalkReplacer = new ChalkReplacer();

        int[] chalk = new int[]{5,1,5};
        int k = 22;
        int expected = 0;
        int result = chalkReplacer.chalkReplacer(chalk, k);
        Assert.assertEquals(expected, result);

        chalk = new int[]{3,4,1,2};
        k = 25;
        expected = 1;
        result = chalkReplacer.chalkReplacer(chalk, k);
        Assert.assertEquals(expected, result);
    }
}
