package com.code.problemset.problem_145;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PostorderTraversalTest {

    @Test
    public void test() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        PostorderTraversal solution = new PostorderTraversal();
        List<Integer> expect = Arrays.asList(2, 3, 1);
        List<Integer> result = solution.postorderTraversal(tree);
        Assert.assertEquals(expect, result);
        result = solution.postorderTraversalV2(tree);
        Assert.assertEquals(expect, result);
        result = solution.postorderTraversalV3(tree);
        Assert.assertEquals(expect, result);
    }

}
