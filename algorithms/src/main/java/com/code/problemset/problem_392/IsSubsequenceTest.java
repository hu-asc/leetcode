package com.code.problemset.problem_392;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-21
 */
public class IsSubsequenceTest {

    @Test
    public void test() {
        IsSubsequence isSubsequence = new IsSubsequence();

        String s = "abc";
        String t = "ahbgdc";
        boolean expected = true;
        boolean result = isSubsequence.isSubsequence(s, t);
        Assert.assertEquals(expected, result);

        s = "axc";
        t = "ahbgdc";
        expected = false;
        result = isSubsequence.isSubsequence(s, t);
        Assert.assertEquals(expected, result);
    }
}
