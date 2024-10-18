package com.code.problemset.problem_2028;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author huhongtao
 * @date 2024-10-18
 */
public class MissingRollsTest {

    @Test
    public void test() {
        MissingRolls missingRolls = new MissingRolls();

        int[] rolls = new int[]{3,2,4,3};
        int mean = 4;
        int n = 2;
        int[] expected = new int[]{6,6};
        int[] result = missingRolls.missingRolls(rolls, mean, n);
        Assert.assertArrayEquals(expected, result);

        rolls = new int[]{1,5,6};
        mean = 3;
        n = 4;
        expected = new int[]{3,2,2,2};
        result = missingRolls.missingRolls(rolls, mean, n);
        Assert.assertArrayEquals(expected, result);

        rolls = new int[]{1,2,3,4};
        mean = 6;
        n = 4;
        expected = new int[]{};
        result = missingRolls.missingRolls(rolls, mean, n);
        Assert.assertArrayEquals(expected, result);
    }
}
