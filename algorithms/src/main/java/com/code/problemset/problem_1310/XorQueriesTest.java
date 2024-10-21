package com.code.problemset.problem_1310;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-20
 */
public class XorQueriesTest {

    @Test
    public void test() {
        XorQueries xorQueries = new XorQueries();

        int[] arr = new int[]{1,3,4,8};
        int[][] queries = new int[][]{{0,1},{1,2},{0,3},{3,3}};
        int[] expected = new int[]{2,7,14,8};
        int[] result = xorQueries.xorQueries(arr, queries);
        Assert.assertArrayEquals(expected, result);

        arr = new int[]{4,8,2,10};
        queries = new int[][]{{2,3},{1,3},{0,0},{0,3}};
        expected = new int[]{8,0,4,4};
        result = xorQueries.xorQueries(arr, queries);
        Assert.assertArrayEquals(expected, result);
    }
}
