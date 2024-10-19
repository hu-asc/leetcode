package com.code.problemset.problem_1367;

import com.code.problemset.ListNode;
import com.code.problemset.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-19
 */
public class IsSubPathTest {

    @Test
    public void test() {
        IsSubPath isSubPath = new IsSubPath();

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);

        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.right = new TreeNode(3);

        boolean expected = true;
        boolean result = isSubPath.isSubPath(head, root);
        Assert.assertEquals(expected, result);
    }
}
