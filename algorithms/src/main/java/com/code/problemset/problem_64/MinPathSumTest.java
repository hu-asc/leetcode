package com.code.problemset.problem_64;

import org.junit.Assert;
import org.junit.Test;

public class MinPathSumTest {

    @Test
    public void test() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int result = 7;
        MinPathSum minPathSum = new MinPathSum();
        Assert.assertEquals(result, minPathSum.minPathSum(grid));

        grid = new int[][]{{1, 2, 3}, {4, 5, 6}};
        result = 12;
        Assert.assertEquals(result, minPathSum.minPathSum(grid));
    }
}
