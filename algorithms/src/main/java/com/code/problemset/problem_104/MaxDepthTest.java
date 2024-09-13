package com.code.problemset.problem_104;

import com.code.problemset.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class MaxDepthTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        MaxDepth solution = new MaxDepth();
        int expect = 2;
        int result = solution.maxDepth(root);
        Assert.assertEquals(expect, result);
        result = solution.maxDepthV2(root);
        Assert.assertEquals(expect, result);
        result = solution.maxDepthV3(root);
        Assert.assertEquals(expect, result);
    }
}
