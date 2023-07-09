package com.code.problem_78;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsTest {

    @Test
    public void test() {
        Subsets solution = new Subsets();
        int[] nums = new int[]{1, 2, 3};

        List<List<Integer>> expectedList = new ArrayList<>();
        expectedList.add(Arrays.asList(1));
        expectedList.add(Arrays.asList(2));
        expectedList.add(Arrays.asList(3));
        expectedList.add(Arrays.asList(1, 2));
        expectedList.add(Arrays.asList(1, 3));
        expectedList.add(Arrays.asList(2, 3));
        expectedList.add(Arrays.asList(1, 2, 3));
        expectedList.add(new ArrayList<>());

        List<List<Integer>> subsets = solution.subsets(nums);
        Assert.assertThat(expectedList, IsIterableContainingInAnyOrder.containsInAnyOrder(subsets.toArray()));

        List<List<Integer>> subsetsV2 = solution.subsetsV2(nums);
        Assert.assertThat(expectedList, IsIterableContainingInAnyOrder.containsInAnyOrder(subsetsV2.toArray()));
    }
}
