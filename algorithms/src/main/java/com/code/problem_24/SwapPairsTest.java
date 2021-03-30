package com.code.problem_24;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwapPairsTest {

    @Test
    public void test() {
        SwapPairs solution = new SwapPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        List<Integer> result = Arrays.asList(2, 1, 4, 3);
        ListNode listNode1 = solution.swapPairs(head);
        List<Integer> result1 = new ArrayList<>();
        while (listNode1 != null) {
            result1.add(listNode1.val);
            listNode1 = listNode1.next;
        }
        Assert.assertEquals(result, result1);

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode listNode2 = solution.swapPairsV2(head);
        List<Integer> result2 = new ArrayList<>();
        while (listNode2 != null) {
            result2.add(listNode2.val);
            listNode2 = listNode2.next;
        }
        Assert.assertEquals(result, result2);
    }
}
