package com.code.problemset.problem_1945;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-17
 */
public class GetLuckyTest {

    @Test
    public void test() {
        GetLucky getLucky = new GetLucky();

        String s = "iiii";
        int k = 1;
        int result = getLucky.getLucky(s, k);
        int expected = 36;
        Assert.assertEquals(expected, result);

        s = "leetcode";
        k = 2;
        result = getLucky.getLucky(s, k);
        expected = 6;
        Assert.assertEquals(expected, result);

        s = "zbax";
        k = 2;
        result = getLucky.getLucky(s, k);
        expected = 8;
        Assert.assertEquals(expected, result);
    }
}
