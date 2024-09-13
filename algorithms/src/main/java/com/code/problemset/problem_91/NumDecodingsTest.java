package com.code.problemset.problem_91;

import org.junit.Assert;
import org.junit.Test;

public class NumDecodingsTest {

    @Test
    public void test() {
        String s = "12";
        int result = 2;
        NumDecodings numDecodings = new NumDecodings();
        Assert.assertEquals(result, numDecodings.numDecodings(s));

        s = "226";
        result = 3;
        Assert.assertEquals(result, numDecodings.numDecodings(s));

        s = "06";
        result = 0;
        Assert.assertEquals(result, numDecodings.numDecodings(s));
    }
}
