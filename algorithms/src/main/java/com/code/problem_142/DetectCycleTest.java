package com.code.problem_142;

import org.junit.Assert;
import org.junit.Test;

public class DetectCycleTest {

    @Test
    public void test() {
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        head.next = second;
        second.next = new ListNode(0);
        second.next.next = new ListNode(4);
        second.next.next.next = second;

        DetectCycle solution = new DetectCycle();
        int result = 2;
        Assert.assertEquals(result, solution.detectCycle(head).val);
        Assert.assertEquals(result, solution.detectCycleV2(head).val);
    }
}
