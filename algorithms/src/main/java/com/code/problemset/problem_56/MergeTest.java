package com.code.problemset.problem_56;

import org.junit.Assert;
import org.junit.Test;

public class MergeTest {

    @Test
    public void mergeTest() {
        Merge merge = new Merge();

        int[][] intervals = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        int[][] result = new int[][]{
                {1, 6},
                {8, 10},
                {15, 18}
        };
        Assert.assertArrayEquals(merge.merge(intervals), result);

        intervals = new int[][]{
                {1, 4},
                {4, 5}
        };
        result = new int[][]{
                {1, 5}
        };
        Assert.assertArrayEquals(merge.merge(intervals), result);
    }

}
