package com.code.problemset.problem_125;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-21
 */
public class IsPalindromeTest {

    @Test
    public void test() {
        IsPalindrome isPalindrome = new IsPalindrome();

        String s = "A man, a plan, a canal: Panama";
        boolean expected = true;
        boolean result = isPalindrome.isPalindrome(s);
        Assert.assertEquals(expected, result);

        s = "race a car";
        expected = false;
        result = isPalindrome.isPalindrome(s);
        Assert.assertEquals(expected, result);

        s = " ";
        expected = true;
        result = isPalindrome.isPalindrome(s);
        Assert.assertEquals(expected, result);
    }
}
