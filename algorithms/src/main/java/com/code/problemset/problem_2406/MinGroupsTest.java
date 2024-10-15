package com.code.problemset.problem_2406;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-15
 */
public class MinGroupsTest {

    @Test
    public void test() {
        MinGroups minGroups = new MinGroups();
        int[][] intervals = new int[][]{{5,10},{6,8},{1,5},{2,3},{1,10}};
        int result = minGroups.minGroups(intervals);
        int expected = 3;
        Assert.assertEquals(expected, result);

        result = minGroups.minGroupsV2(intervals);
        Assert.assertEquals(expected, result);

        intervals = new int[][]{{1,3},{5,6},{8,10},{11,13}};
        result = minGroups.minGroups(intervals);
        expected = 1;
        Assert.assertEquals(expected, result);

        result = minGroups.minGroupsV2(intervals);
        Assert.assertEquals(expected, result);
    }
}
