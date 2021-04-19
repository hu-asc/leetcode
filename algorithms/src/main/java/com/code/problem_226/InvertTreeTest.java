package com.code.problem_226;

import com.code.TreeNode;
import com.code.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class InvertTreeTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        InvertTree solution = new InvertTree();
        TreeNode treeNode = solution.invertTree(root);
        List<Integer> expect = Arrays.asList(3, 2, 1);
        Assert.assertEquals(expect, Utils.inorder(treeNode));

        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        treeNode = solution.invertTreeV2(root);
        Assert.assertEquals(expect, Utils.inorder(treeNode));
    }
}
