package com.code.problemset.problem_2696;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-15
 */
public class MinLengthTest {

    @Test
    public void test() {
        String s = "ABFCACDB";
        MinLength minLength = new MinLength();
        int result = minLength.minLength(s);
        int expected = 2;

        Assert.assertEquals(expected, result);
        result = minLength.minLengthV2(s);
        Assert.assertEquals(expected, result);
        result = minLength.minLengthV3(s);
        Assert.assertEquals(expected, result);

        s = "ACBBD";
        expected = 5;
        result = minLength.minLength(s);
        Assert.assertEquals(expected, result);
        result = minLength.minLengthV2(s);
        Assert.assertEquals(expected, result);
        result = minLength.minLengthV3(s);
        Assert.assertEquals(expected, result);
    }
}
