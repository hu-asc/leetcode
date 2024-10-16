package com.code.problemset.problem_1497;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-09
 */
public class CanArrangeTest {

    @Test
    public void test() {
        CanArrange canArrange = new CanArrange();

        int[] arr = new int[]{1,2,3,4,5,10,6,7,8,9};
        int k = 5;
        boolean expected = true;
        boolean result = canArrange.canArrange(arr, k);
        Assert.assertEquals(expected, result);
        result = canArrange.canArrangeV2(arr, k);
        Assert.assertEquals(expected, result);

        arr = new int[]{1,2,3,4,5,6};
        k = 7;
        expected = true;
        result = canArrange.canArrange(arr, k);
        Assert.assertEquals(expected, result);
        result = canArrange.canArrangeV2(arr, k);
        Assert.assertEquals(expected, result);

        arr = new int[]{1,2,3,4,5,6};
        k = 10;
        expected = false;
        result = canArrange.canArrange(arr, k);
        Assert.assertEquals(expected, result);
        result = canArrange.canArrangeV2(arr, k);
        Assert.assertEquals(expected, result);
    }
}
