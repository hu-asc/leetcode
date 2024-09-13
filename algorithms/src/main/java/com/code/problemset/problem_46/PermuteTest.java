package com.code.problemset.problem_46;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteTest {

    @Test
    public void test() {
        Permute solution = new Permute();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> expectList = new ArrayList<>();
        expectList.add(Arrays.asList(1, 2, 3));
        expectList.add(Arrays.asList(1, 3, 2));
        expectList.add(Arrays.asList(2, 1, 3));
        expectList.add(Arrays.asList(2, 3, 1));
        expectList.add(Arrays.asList(3, 1, 2));
        expectList.add(Arrays.asList(3, 2, 1));
        List<List<Integer>> permute = solution.permute(nums);
        Assert.assertThat(expectList, IsIterableContainingInAnyOrder.containsInAnyOrder(permute.toArray()));

        List<List<Integer>> permuteV2 = solution.permuteV2(nums);
        Assert.assertThat(expectList, IsIterableContainingInAnyOrder.containsInAnyOrder(permuteV2.toArray()));
    }
}