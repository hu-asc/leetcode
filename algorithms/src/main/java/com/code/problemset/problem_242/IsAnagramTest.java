package com.code.problemset.problem_242;

import org.junit.Assert;
import org.junit.Test;

public class IsAnagramTest {

    @Test
    public void test() {
        IsAnagram solution = new IsAnagram();
        String s = "rat";
        String t = "car";
        boolean result = false;
        Assert.assertEquals(result, solution.isAnagram(s, t));
        Assert.assertEquals(result, solution.isAnagramV2(s, t));
    }
}
