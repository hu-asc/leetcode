package com.code.problem_515;

import com.code.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LargestValuesTest {

    @Test
    public void test() {
        LargestValues t = new LargestValues();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        List<Integer> expect = new ArrayList<Integer>() {{
            add(1);
            add(3);
            add(9);
        }};
        List<Integer> result = t.largestValues(root);
        Assert.assertEquals(expect, result);
        result = t.largestValues(root);
        Assert.assertEquals(expect, result);
    }

}
