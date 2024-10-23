package com.code.problemset.problem_211;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-23
 */
public class WordDictionaryTest {

    @Test
    public void test() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        boolean expected = false;
        boolean result = wordDictionary.search("pad");
        Assert.assertEquals(expected, result);
        expected = true;
        result = wordDictionary.search("bad");
        Assert.assertEquals(expected, result);
        result = wordDictionary.search(".ad");
        Assert.assertEquals(expected, result);
        result = wordDictionary.search("b..");
        Assert.assertEquals(expected, result);
    }
}
