package com.code.problemset.problem_1684;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-20
 */
public class CountConsistentStringsTest {

    @Test
    public void test() {
        CountConsistentStrings countConsistentStrings = new CountConsistentStrings();

        String allowed = "ab";
        String[] words = new String[]{"ad","bd","aaab","baa","badab"};
        int expected = 2;
        int result = countConsistentStrings.countConsistentStrings(allowed, words);
        Assert.assertEquals(expected ,result);

        allowed = "abc";
        words = new String[]{"a","b","c","ab","ac","bc","abc"};
        expected = 7;
        result = countConsistentStrings.countConsistentStrings(allowed, words);
        Assert.assertEquals(expected ,result);
    }
}
