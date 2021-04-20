package com.code.problem_98;

import com.code.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class IsValidBSTTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        IsValidBST solution = new IsValidBST();
        boolean expect = false;
        boolean result = solution.isValidBST(root);
        Assert.assertEquals(expect, result);
        result = solution.isValidBSTV2(root);
        Assert.assertEquals(expect, result);
    }
}
