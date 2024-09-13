package com.code.problemset.problem_77;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombineTest {

    @Test
    public void test() {
        Combine solution = new Combine();
        int n = 4;
        int k = 2;
        List<List<Integer>> expectedList = new ArrayList<>();
        expectedList.add(Arrays.asList(1, 2));
        expectedList.add(Arrays.asList(1, 3));
        expectedList.add(Arrays.asList(1, 4));
        expectedList.add(Arrays.asList(2, 3));
        expectedList.add(Arrays.asList(2, 4));
        expectedList.add(Arrays.asList(3, 4));
        List<List<Integer>> combine = solution.combine(n, k);
        Assert.assertThat(expectedList, IsIterableContainingInAnyOrder.containsInAnyOrder(combine.toArray()));

        List<List<Integer>> combineV2 = solution.combineV2(n, k);
        Assert.assertThat(expectedList, IsIterableContainingInAnyOrder.containsInAnyOrder(combineV2.toArray()));
    }


}
