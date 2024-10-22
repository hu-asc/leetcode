package com.code.problemset.problem_230;

import com.code.problemset.TreeNode;
import com.code.problemset.TreeNodeUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-22
 */
public class KthSmallestTest {

    @Test
    public void test() {
        KthSmallest kthSmallest = new KthSmallest();

        Integer[] nums = new Integer[]{3,1,4,null,2};
        TreeNode root = TreeNodeUtil.toTreeNode(nums);
        int k = 1;
        int expected = 1;
        int result = kthSmallest.kthSmallest(root, k);
        Assert.assertEquals(expected, result);
        result = kthSmallest.kthSmallestV2(root, k);
        Assert.assertEquals(expected, result);

        nums = new Integer[]{5,3,6,2,4,null,null,1};
        k = 3;
        expected = 3;
        result = kthSmallest.kthSmallest(root, k);
        Assert.assertEquals(expected, result);
        result = kthSmallest.kthSmallestV2(root, k);
        Assert.assertEquals(expected, result);
    }
}
