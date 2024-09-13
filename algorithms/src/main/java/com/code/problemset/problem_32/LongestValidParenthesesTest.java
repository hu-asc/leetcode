package com.code.problemset.problem_32;

import org.junit.Assert;
import org.junit.Test;

public class LongestValidParenthesesTest {

    @Test
    public void test() {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        String s = "(()";
        int result = 2;
        Assert.assertEquals(result, longestValidParentheses.longestValidParentheses(s));

        s = ")()())";
        result = 4;
        Assert.assertEquals(result, longestValidParentheses.longestValidParentheses(s));

        s = "";
        result = 0;
        Assert.assertEquals(result, longestValidParentheses.longestValidParentheses(s));

        s = "(()())";
        result = 6;
        Assert.assertEquals(result, longestValidParentheses.longestValidParentheses(s));
    }
}
