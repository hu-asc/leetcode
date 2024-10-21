package com.code.problemset.problem_3;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-21
 */
public class LengthOfLongestSubstringTest {

    @Test
    public void test() {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        String s = "abcabcbb";
        int expected = 3;
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring(s);
        Assert.assertEquals(expected, result);

        s = "bbbbb";
        expected = 1;
        result = lengthOfLongestSubstring.lengthOfLongestSubstring(s);
        Assert.assertEquals(expected, result);

        s = "pwwkew";
        expected = 3;
        result = lengthOfLongestSubstring.lengthOfLongestSubstring(s);
        Assert.assertEquals(expected, result);
    }
}
