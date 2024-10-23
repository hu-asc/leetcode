package com.code.problemset.problem_199;

import com.code.problemset.TreeNode;
import com.code.problemset.TreeNodeUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author huhongtao
 * @date 2024-10-23
 */
public class RightSideViewTest {

    @Test
    public void test() {
        RightSideView rightSideView = new RightSideView();

        Integer[] nums = new Integer[]{1,2,3,null,5,null,4};
        TreeNode treeNode = TreeNodeUtil.toTreeNode(nums);
        List<Integer> expected = Arrays.asList(1, 3, 4);
        List<Integer> result = rightSideView.rightSideView(treeNode);
        Assert.assertEquals(expected, result);

        result = rightSideView.rightSideViewV2(treeNode);
        Assert.assertEquals(expected, result);
    }
}
