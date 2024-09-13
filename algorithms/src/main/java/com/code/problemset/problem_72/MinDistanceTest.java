package com.code.problemset.problem_72;

import org.junit.Assert;
import org.junit.Test;

public class MinDistanceTest {

    @Test
    public void test() {
        String word1 = "horse";
        String word2 = "ros";
        int result = 3;
        MinDistance minDistance = new MinDistance();
        Assert.assertEquals(result, minDistance.minDistance(word1, word2));

        word1 = "intention";
        word2 = "execution";
        result = 5;
        Assert.assertEquals(result, minDistance.minDistance(word1, word2));
    }

}
