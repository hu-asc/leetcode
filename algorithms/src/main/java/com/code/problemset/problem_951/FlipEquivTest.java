package com.code.problemset.problem_951;

import com.code.problemset.TreeNode;
import com.code.problemset.TreeNodeUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-24
 */
public class FlipEquivTest {

    @Test
    public void test() {
        FlipEquiv flipEquiv = new FlipEquiv();

        Integer[] nums1 = new Integer[]{1,2,3,4,5,6,null,null,null,7,8};
        Integer[] nums2 = new Integer[]{1,3,2,null,6,4,5,null,null,null,null,8,7};
        TreeNode root1 = TreeNodeUtil.toTreeNode(nums1);
        TreeNode root2 = TreeNodeUtil.toTreeNode(nums2);
        boolean expected = true;
        boolean result = flipEquiv.flipEquiv(root1, root2);
        Assert.assertEquals(expected, result);

        result = flipEquiv.flipEquivV2(root1, root2);
        Assert.assertEquals(expected, result);
    }
}
