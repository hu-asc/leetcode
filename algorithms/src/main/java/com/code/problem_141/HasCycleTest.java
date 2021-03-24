package com.code.problem_141;

import org.junit.Assert;
import org.junit.Test;

public class HasCycleTest {

    @Test
    public void test() {
        ListNode node = new ListNode(3);
        ListNode secondNode = new ListNode(2);
        node.next = secondNode;
        node.next.next = new ListNode(0);
        ListNode lastNode = new ListNode(-4);
        node.next.next.next = lastNode;
        lastNode.next = secondNode;

        HasCycle solution = new HasCycle();
        boolean result = true;
        Assert.assertEquals(result, solution.hasCycle(node));
        Assert.assertEquals(result, solution.hasCycleV2(node));
    }
}
