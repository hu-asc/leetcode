package com.code.problem_200;

import org.junit.Assert;
import org.junit.Test;

public class NumIslandsTest {

    @Test
    public void test() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = new char[4][5];
        grid[0] = new char[]{'1', '1', '0', '0', '0'};
        grid[1] = new char[]{'1', '1', '0', '0', '0'};
        grid[2] = new char[]{'0', '0', '1', '0', '0'};
        grid[3] = new char[]{'0', '0', '0', '1', '1'};
        char[][] newGrid = new char[4][5];
        for (int i = 0; i < grid.length; i++) {
            newGrid[i] = grid[i].clone();
        }

        int expect = 3;
        int result = numIslands.numIslands(grid);
        Assert.assertEquals(expect, result);
        result = numIslands.numIslandsV2(newGrid);
        Assert.assertEquals(expect, result);
    }
}
