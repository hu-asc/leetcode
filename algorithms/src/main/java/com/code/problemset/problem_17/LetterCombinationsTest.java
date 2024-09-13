package com.code.problemset.problem_17;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsTest {

    @Test
    public void test() {
        LetterCombinations solution = new LetterCombinations();
        String digits = "23";
        List<String> expectedList = new ArrayList<>();
        expectedList.addAll(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));

        List<String> result = solution.letterCombinations(digits);
        Assert.assertThat(expectedList, IsIterableContainingInAnyOrder.containsInAnyOrder(result.toArray()));
    }
}
