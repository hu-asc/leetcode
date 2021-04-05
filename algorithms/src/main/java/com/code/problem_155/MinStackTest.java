package com.code.problem_155;

import org.junit.Assert;
import org.junit.Test;

public class MinStackTest {

    @Test
    public void test() {
        MinStack solution = new MinStack();
        solution.push(-2);
        solution.push(0);
        solution.push(-3);
        Assert.assertEquals(-3, solution.getMin());
        solution.pop();
        Assert.assertEquals(0, solution.top());
        Assert.assertEquals(-2, solution.getMin());

        MinStackV2 solutionV2 = new MinStackV2();
        solutionV2.push(-2);
        solutionV2.push(0);
        solutionV2.push(-3);
        Assert.assertEquals(-3, solutionV2.getMin());
        solutionV2.pop();
        Assert.assertEquals(0, solutionV2.top());
        Assert.assertEquals(-2, solutionV2.getMin());

        MinStackV3 solutionV3 = new MinStackV3();
        solutionV3.push(-2);
        solutionV3.push(0);
        solutionV3.push(-3);
        Assert.assertEquals(-3, solutionV3.getMin());
        solutionV3.pop();
        Assert.assertEquals(0, solutionV3.top());
        Assert.assertEquals(-2, solutionV3.getMin());
    }

}
