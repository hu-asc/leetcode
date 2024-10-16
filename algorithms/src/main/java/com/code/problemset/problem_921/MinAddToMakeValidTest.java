package com.code.problemset.problem_921;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-09
 */
public class MinAddToMakeValidTest {

    @Test
    public void test() {
        MinAddToMakeValid minAddToMakeValid = new MinAddToMakeValid();

        String s = "())";
        int expected = 1;
        int result = minAddToMakeValid.minAddToMakeValid(s);
        Assert.assertEquals(expected, result);

        result = minAddToMakeValid.minAddToMakeValidV2(s);
        Assert.assertEquals(expected, result);

        s = "(((";
        expected = 3;
        result = minAddToMakeValid.minAddToMakeValid(s);
        Assert.assertEquals(expected, result);
        result = minAddToMakeValid.minAddToMakeValidV2(s);
        Assert.assertEquals(expected, result);
    }
}
