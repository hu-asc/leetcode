package com.code.problemset.problem_2022;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author huhongtao
 * @date 2024-10-16
 */
public class Construct2DArrayTest {

    @Test
    public void test() {
        Construct2DArray construct2DArray = new Construct2DArray();

        int[] original = new int[]{1, 2, 3, 4};
        int m = 2;
        int n = 2;
        int[][] result = construct2DArray.construct2DArray(original, m, n);
        int[][] expected = new int[][]{{1,2},{3,4}};
        Assert.assertArrayEquals(expected, result);

        original = new int[]{1, 2, 3};
        m = 1;
        n = 3;
        result = construct2DArray.construct2DArray(original, m, n);
        expected = new int[][]{{1,2,3}};
        Assert.assertArrayEquals(expected, result);

        original = new int[]{1, 2};
        m = 1;
        n = 1;
        result = construct2DArray.construct2DArray(original, m, n);
        expected = new int[][]{};
        Assert.assertArrayEquals(expected, result);
    }
}
