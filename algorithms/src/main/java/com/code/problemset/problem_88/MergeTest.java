package com.code.problemset.problem_88;

import org.junit.Assert;
import org.junit.Test;

public class MergeTest {

    @Test
    public void test() {
        Merge solution = new Merge();
        int[] nums1 = new int[]{0};
        int m = 0;
        int[] nums2 = new int[]{1};
        int n = 1;
        int[] result = new int[]{1};
        solution.merge(nums1, m, nums2, n);
        Assert.assertArrayEquals(result, nums1);
        nums1 = new int[]{0};
        solution.mergeV2(nums1, m, nums2, n);
        Assert.assertArrayEquals(result, nums1);
    }
}
