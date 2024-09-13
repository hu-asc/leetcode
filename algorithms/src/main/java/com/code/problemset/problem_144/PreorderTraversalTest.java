package com.code.problemset.problem_144;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PreorderTraversalTest {

    @Test
    public void test() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        PreorderTraversal solution = new PreorderTraversal();
        List<Integer> result = solution.preorderTraversal(tree);
        List<Integer> expect = Arrays.asList(1, 2, 3);
        Assert.assertEquals(result, expect);
        result = solution.preorderTraversalV2(tree);
        Assert.assertEquals(result, expect);
    }
}
