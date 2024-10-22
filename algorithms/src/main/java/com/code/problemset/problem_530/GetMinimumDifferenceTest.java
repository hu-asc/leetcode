package com.code.problemset.problem_530;

import com.code.problemset.TreeNode;
import com.code.problemset.TreeNodeUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-22
 */
public class GetMinimumDifferenceTest {

    @Test
    public void test() {
        GetMinimumDifference getMinimumDifference = new GetMinimumDifference();

        Integer[] nums = new Integer[]{4,2,6,1,3};
        TreeNode treeNode = TreeNodeUtil.toTreeNode(nums);
        int expected = 1;
        int minimumDifference = getMinimumDifference.getMinimumDifference(treeNode);
        Assert.assertEquals(expected, minimumDifference);

        nums = new Integer[]{1,0,48,null,null,12,49};
        treeNode = TreeNodeUtil.toTreeNode(nums);
        expected = 1;
        minimumDifference = getMinimumDifference.getMinimumDifference(treeNode);
        Assert.assertEquals(expected, minimumDifference);
    }
}
