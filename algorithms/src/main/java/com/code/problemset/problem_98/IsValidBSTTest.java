package com.code.problemset.problem_98;

import com.code.problemset.TreeNode;
import com.code.problemset.TreeNodeUtil;
import org.junit.Assert;
import org.junit.Test;

public class IsValidBSTTest {

    @Test
    public void test() {
        IsValidBST solution = new IsValidBST();
        Integer[] nums = new Integer[]{5,1,4,null,null,3,6};
        TreeNode root = TreeNodeUtil.toTreeNode(nums);
        boolean expect = false;
        boolean result = solution.isValidBST(root);
        Assert.assertEquals(expect, result);
        result = solution.isValidBSTV2(root);
        Assert.assertEquals(expect, result);
        result = solution.isValidBSTV3(root);
        Assert.assertEquals(expect, result);
        result = solution.isValidBSTV4(root);
        Assert.assertEquals(expect, result);
    }
}
