package com.code.problemset.problem_1813;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-08
 */
public class AreSentencesSimilarTest {

    @Test
    public void test() {
        AreSentencesSimilar areSentencesSimilar = new AreSentencesSimilar();
        String sentence1 = "My name is Haley", sentence2 = "My Haley";
        boolean expected = true;
        boolean result = areSentencesSimilar.areSentencesSimilar(sentence1, sentence2);
        Assert.assertEquals(expected, result);
        result = areSentencesSimilar.areSentencesSimilarV2(sentence1, sentence2);
        Assert.assertEquals(expected, result);

        sentence1 = "of";
        sentence2 = "A lot of words";
        expected = false;
        result = areSentencesSimilar.areSentencesSimilar(sentence1, sentence2);
        Assert.assertEquals(expected, result);
        result = areSentencesSimilar.areSentencesSimilarV2(sentence1, sentence2);
        Assert.assertEquals(expected, result);

        sentence1 = "Eating right now";
        sentence2 = "Eating";
        expected = true;
        result = areSentencesSimilar.areSentencesSimilar(sentence1, sentence2);
        Assert.assertEquals(expected, result);
        result = areSentencesSimilar.areSentencesSimilarV2(sentence1, sentence2);
        Assert.assertEquals(expected, result);
    }
}
