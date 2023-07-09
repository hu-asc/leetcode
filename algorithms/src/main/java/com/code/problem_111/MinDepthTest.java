package com.code.problem_111;

import com.code.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class MinDepthTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        MinDepth solution = new MinDepth();
        int expect = 2;
        int result = solution.minDepth(root);
        Assert.assertEquals(expect, result);
        result = solution.minDepthV2(root);
        Assert.assertEquals(expect, result);
    }
}
