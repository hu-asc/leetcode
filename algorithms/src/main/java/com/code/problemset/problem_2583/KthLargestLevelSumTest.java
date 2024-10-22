package com.code.problemset.problem_2583;

import com.code.problemset.TreeNode;
import com.code.problemset.TreeNodeUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-22
 */
public class KthLargestLevelSumTest {

    @Test
    public void test() {
        KthLargestLevelSum kthLargestLevelSum = new KthLargestLevelSum();

        Integer[] nums = new Integer[]{5,8,9,2,1,3,7,4,6};
        int k = 2;
        TreeNode treeNode = TreeNodeUtil.toTreeNode(nums);
        long expected = 13;
        long result = kthLargestLevelSum.kthLargestLevelSum(treeNode, k);
        Assert.assertEquals(expected, result);
        result = kthLargestLevelSum.kthLargestLevelSumV2(treeNode, k);
        Assert.assertEquals(expected, result);

        nums = new Integer[]{1,2,null,3};
        k = 1;
        treeNode = TreeNodeUtil.toTreeNode(nums);
        expected = 3;
        result = kthLargestLevelSum.kthLargestLevelSum(treeNode, k);
        Assert.assertEquals(expected, result);
        result = kthLargestLevelSum.kthLargestLevelSumV2(treeNode, k);
        Assert.assertEquals(expected, result);
    }
}
