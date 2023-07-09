package com.code.problem_102;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelOrderTest {

    @Test
    public void test() {
        LevelOrder solution = new LevelOrder();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> expectList = new ArrayList<>();
        expectList.add(Arrays.asList(3));
        expectList.add(Arrays.asList(9, 20));
        expectList.add(Arrays.asList(15, 7));

        List<List<Integer>> result = solution.levelOrder(root);
        Assert.assertThat(result, IsIterableContainingInOrder.contains(expectList.toArray()));

        List<List<Integer>> result2 = solution.levelOrderV2(root);
        Assert.assertThat(result2, IsIterableContainingInOrder.contains(expectList.toArray()));
    }
}
