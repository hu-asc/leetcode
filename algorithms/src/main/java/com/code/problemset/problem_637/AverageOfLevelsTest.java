package com.code.problemset.problem_637;

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
public class AverageOfLevelsTest {

    @Test
    public void test() {
        AverageOfLevels averageOfLevels = new AverageOfLevels();

        Integer[] nums = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = TreeNodeUtil.toTreeNode(nums);
        List<Double> expected = Arrays.asList(3.00000,14.50000,11.00000);

        List<Double> result = averageOfLevels.averageOfLevels(root);
        Assert.assertEquals(expected, result);
        result = averageOfLevels.averageOfLevelsV2(root);
        Assert.assertEquals(expected, result);
    }
}
