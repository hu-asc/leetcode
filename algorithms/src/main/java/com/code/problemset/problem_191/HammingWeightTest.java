package com.code.problemset.problem_191;

import org.junit.Assert;
import org.junit.Test;

public class HammingWeightTest {

    @Test
    public void test() {
        HammingWeight solution = new HammingWeight();
        int n = 00000000000000000000000010000000;
        int expect = 3;
        Assert.assertEquals(expect, solution.hammingWeight(n));
        Assert.assertEquals(expect, solution.hammingWeightV2(n));
    }

}
