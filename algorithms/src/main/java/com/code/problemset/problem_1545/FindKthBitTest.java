package com.code.problemset.problem_1545;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-19
 */
public class FindKthBitTest {

    @Test
    public void test() {
        FindKthBit findKthBit = new FindKthBit();

        int n = 3;
        int k = 1;
        char expected = '0';
        char result = findKthBit.findKthBit(n, k);
        Assert.assertEquals(expected, result);
        result = findKthBit.findKthBitV2(n, k);
        Assert.assertEquals(expected, result);
        result = findKthBit.findKthBitV3(n, k);
        Assert.assertEquals(expected, result);

        n = 4;
        k = 11;
        expected = '1';
        result = findKthBit.findKthBit(n, k);
        Assert.assertEquals(expected, result);
        result = findKthBit.findKthBitV2(n, k);
        Assert.assertEquals(expected, result);
        result = findKthBit.findKthBitV3(n, k);
        Assert.assertEquals(expected, result);
    }
}
