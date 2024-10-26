package com.code.problemset.problem_2458;

import com.code.problemset.TreeNode;
import com.code.problemset.TreeNodeUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-26
 */
public class TreeQueriesTest {

    @Test
    public void test() {
        TreeQueries treeQueries = new TreeQueries();

        Integer[] nums = new Integer[]{1,3,4,2,null,6,5,null,null,null,null,null,7};
        TreeNode root = TreeNodeUtil.toTreeNode(nums);
        int[] queries = new int[]{4};

        int[] expected = new int[]{2};
        int[] result = treeQueries.treeQueries(root, queries);
        Assert.assertArrayEquals(expected, result);
    }


}
