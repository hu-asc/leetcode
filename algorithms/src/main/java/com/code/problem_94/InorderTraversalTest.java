package com.code.problem_94;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class InorderTraversalTest {

    @Test
    public void test() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        InorderTraversal solution = new InorderTraversal();
        List<Integer> expected = Arrays.asList(2, 1, 3);
        List<Integer> result = solution.inorderTraversal(tree);
        Assert.assertEquals(expected, result);
        result = solution.inorderTraversalV2(tree);
        Assert.assertEquals(expected, result);
        result = solution.inorderTraversalV3(tree);
        Assert.assertEquals(expected, result);
    }
}
