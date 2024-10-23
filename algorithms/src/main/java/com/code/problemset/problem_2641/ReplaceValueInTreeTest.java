package com.code.problemset.problem_2641;

import com.code.problemset.TreeNode;
import com.code.problemset.TreeNodeUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-23
 */
public class ReplaceValueInTreeTest {

    @Test
    public void test() {
        ReplaceValueInTree replaceValueInTree = new ReplaceValueInTree();

        Integer[] nums = new Integer[]{5,4,9,1,10,null,7};
        TreeNode root = TreeNodeUtil.toTreeNode(nums);
        Integer[] expected = new Integer[]{0,0,0,7,7,null,11};
        TreeNode treeNode = replaceValueInTree.replaceValueInTree(root);
        Integer[] result = TreeNodeUtil.toArray(treeNode);
        Assert.assertArrayEquals(expected, result);

        root = TreeNodeUtil.toTreeNode(nums);
        treeNode = replaceValueInTree.replaceValueInTreeV2(root);
        result = TreeNodeUtil.toArray(treeNode);
        Assert.assertArrayEquals(expected, result);
    }
}
