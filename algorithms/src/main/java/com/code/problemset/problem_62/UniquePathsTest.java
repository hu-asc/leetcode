package com.code.problemset.problem_62;

import org.junit.Assert;
import org.junit.Test;

public class UniquePathsTest {

    @Test
    public void test() {
        UniquePaths solution = new UniquePaths();
        int m = 3;
        int n = 7;
        int result = 28;;
        Assert.assertTrue(result == solution.uniquePaths(m, n));
        Assert.assertTrue(result == solution.uniquePathsV2(m, n));
        Assert.assertTrue(result == solution.uniquePathsV3(m, n));
        n = 3;
        result = 6;
        Assert.assertTrue(result == solution.uniquePaths(m, n));
        Assert.assertTrue(result == solution.uniquePathsV2(m, n));
        Assert.assertTrue(result == solution.uniquePathsV3(m, n));
    }

}
