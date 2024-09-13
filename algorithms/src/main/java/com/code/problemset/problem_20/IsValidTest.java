package com.code.problemset.problem_20;

import org.junit.Assert;
import org.junit.Test;

public class IsValidTest {

    @Test
    public void test() {
        IsValid solution = new IsValid();
        String s = "{[]}}";
        boolean result = false;
        Assert.assertTrue(solution.isValid(s) == result);
        Assert.assertTrue(solution.isValidV2(s) == result);
    }
}
