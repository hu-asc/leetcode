package com.code.problemset.problem_76;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-21
 */
public class minWindowTest {

    @Test
    public void test() {
        MinWindow minWindow = new MinWindow();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String expected = "BANC";
        String result = minWindow.minWindow(s, t);
        Assert.assertEquals(expected, result);

        s = "a";
        t = "a";
        expected = "a";
        result = minWindow.minWindow(s, t);
        Assert.assertEquals(expected, result);

        s = "a";
        t = "aa";
        expected = "";
        result = minWindow.minWindow(s, t);
        Assert.assertEquals(expected, result);
    }

}
