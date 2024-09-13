package com.code.problemset.problem_22;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GenerateParenthesisTest {

    @Test
    public void test() {
        int n = 3;
        GenerateParenthesis solution = new GenerateParenthesis();
        List<String> expect = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        List<String> result = solution.generateParenthesis(n);
        Assert.assertEquals(result, expect);
        result = solution.generateParenthesisV2(n);
        Assert.assertEquals(result, expect);
    }
}
