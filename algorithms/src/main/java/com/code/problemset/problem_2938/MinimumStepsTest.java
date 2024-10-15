package com.code.problemset.problem_2938;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-15
 */
public class MinimumStepsTest {

    @Test
    public void test() {
        MinimumSteps minimumSteps = new MinimumSteps();

        String s = "101";
        long expected = 1;
        long result = minimumSteps.minimumSteps(s);
        Assert.assertEquals(expected, result);
        result = minimumSteps.minimumStepsV2(s);
        Assert.assertEquals(expected, result);

        s = "100";
        expected = 2;
        result = minimumSteps.minimumSteps(s);
        Assert.assertEquals(expected, result);
        result = minimumSteps.minimumStepsV2(s);
        Assert.assertEquals(expected, result);

        s = "0111";
        expected = 0;
        result = minimumSteps.minimumSteps(s);
        Assert.assertEquals(expected, result);
        result = minimumSteps.minimumStepsV2(s);
        Assert.assertEquals(expected, result);
    }
}
