package com.code.problemset.problem_1331;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-09
 */
public class ArrayRankTransformTest {

    @Test
    public void test() {
        ArrayRankTransform arrayRankTransform = new ArrayRankTransform();
        int[] arr = new int[]{40,10,20,30};
        int[] expected = new int[]{4, 1, 2, 3};
        int[] result = arrayRankTransform.arrayRankTransform(arr);
        Assert.assertArrayEquals(expected, result);


        arr = new int[]{100,100,100};
        expected = new int[]{1, 1, 1};
        result = arrayRankTransform.arrayRankTransform(arr);
        Assert.assertArrayEquals(expected, result);

        arr = new int[]{37,12,28,9,100,56,80,5,12};
        expected = new int[]{5, 3, 4, 2, 8, 6, 7, 1, 3};
        result = arrayRankTransform.arrayRankTransform(arr);
        Assert.assertArrayEquals(expected, result);
    }
}
