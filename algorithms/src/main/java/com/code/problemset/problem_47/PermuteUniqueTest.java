package com.code.problemset.problem_47;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUniqueTest {

    @Test
    public void test() {
        PermuteUnique solution = new PermuteUnique();
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> expectList = new ArrayList<>();
        expectList.add(Arrays.asList(1, 1, 2));
        expectList.add(Arrays.asList(1, 2, 1));
        expectList.add(Arrays.asList(2, 1, 1));
        List<List<Integer>> permuteUnique = solution.permuteUnique(nums);
        Assert.assertThat(expectList, IsIterableContainingInAnyOrder.containsInAnyOrder(permuteUnique.toArray()));
    }
}
