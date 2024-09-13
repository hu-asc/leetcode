package com.code.problemset.problem_50;

import org.junit.Assert;
import org.junit.Test;

public class MyPowTest {

    @Test
    public void test() {
        MyPow solution = new MyPow();
        double x = 2.10000;
        int n = 3;
        double result = solution.myPow(x, n);
        double expectedResult = 9.26100;
        Assert.assertEquals(result, expectedResult, 0.0001);
        double result2 = solution.myPowV2(x, n);
        Assert.assertEquals(result2, expectedResult, 0.0001);
    }

}
