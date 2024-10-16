package com.code.problemset.problem_567;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-08
 */
public class CheckInclusionTest {

    @Test
    public void test() {
        CheckInclusion checkInclusion = new CheckInclusion();

        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean expected = true;
        boolean result = checkInclusion.checkInclusion(s1, s2);
        Assert.assertEquals(expected, result);

        result = checkInclusion.checkInclusionV2(s1, s2);
        Assert.assertEquals(expected, result);

        s1 = "ab";
        s2 = "eidboaoo";
        expected = false;
        result = checkInclusion.checkInclusion(s1, s2);
        Assert.assertEquals(expected, result);
        result = checkInclusion.checkInclusion(s1, s2);
        Assert.assertEquals(expected, result);
    }

}
