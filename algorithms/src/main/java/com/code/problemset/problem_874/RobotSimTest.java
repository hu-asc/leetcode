package com.code.problemset.problem_874;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-17
 */
public class RobotSimTest {

    @Test
    public void test() {
        RobotSim robotSim = new RobotSim();

        int[] commands = new int[]{4,-1,3};
        int[][] obstacles = new int[][]{};
        int expected = 25;
        int result = robotSim.robotSim(commands, obstacles);
        Assert.assertEquals(expected, result);

        commands = new int[]{4,-1,4,-2,4};
        obstacles = new int[][]{{2,4}};
        expected = 65;
        result = robotSim.robotSim(commands, obstacles);
        Assert.assertEquals(expected, result);

        commands = new int[]{6,-1,-1,6};
        obstacles = new int[][]{{0, 0}};
        expected = 36;
        result = robotSim.robotSim(commands, obstacles);
        Assert.assertEquals(expected, result);
    }
}
