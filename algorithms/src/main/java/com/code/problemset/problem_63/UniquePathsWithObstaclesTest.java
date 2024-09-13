package com.code.problemset.problem_63;

import org.junit.Assert;
import org.junit.Test;

public class UniquePathsWithObstaclesTest {

    @Test
    public void test() {
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        int[][] obstacleGrid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int result = 2;
        Assert.assertEquals(result, uniquePathsWithObstacles.uniquePathsWithObstacles(obstacleGrid));
        Assert.assertEquals(result, uniquePathsWithObstacles.uniquePathsWithObstaclesV2(obstacleGrid));

        obstacleGrid = new int[][]{
                {0, 1},
                {0, 0}
        };
        result = 1;
        Assert.assertEquals(result, uniquePathsWithObstacles.uniquePathsWithObstacles(obstacleGrid));
        Assert.assertEquals(result, uniquePathsWithObstacles.uniquePathsWithObstaclesV2(obstacleGrid));
    }

}
