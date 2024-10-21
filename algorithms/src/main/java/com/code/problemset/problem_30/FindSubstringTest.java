package com.code.problemset.problem_30;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huhongtao
 * @date 2024-10-21
 */
public class FindSubstringTest {

    @Test
    public void test() {
        FindSubstring findSubstring = new FindSubstring();

        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};
        List<Integer> expected = Arrays.asList(0, 9);
        List<Integer> result = findSubstring.findSubstring(s, words);
        Assert.assertEquals(expected, result);

        s = "wordgoodgoodgoodbestword";
        words = new String[]{"word","good","best","word"};
        expected = new ArrayList<>();
        result = findSubstring.findSubstring(s, words);
        Assert.assertEquals(expected, result);

        s = "barfoofoobarthefoobarman";
        words = new String[]{"bar","foo","the"};
        expected = Arrays.asList(6, 9, 12);;
        result = findSubstring.findSubstring(s, words);
        Assert.assertEquals(expected, result);
    }
}
