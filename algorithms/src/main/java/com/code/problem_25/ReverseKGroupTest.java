package com.code.problem_25;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseKGroupTest {

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseKGroup solution = new ReverseKGroup();
        int k = 2;
        List<Integer> result = Arrays.asList(2, 1, 4, 3, 5);
        ListNode listNode = solution.reverseKGroup(head, k);
        List<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Assert.assertEquals(result, list);

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        listNode = solution.reverseKGroupV2(head, k);
        List<Integer> list2 = new ArrayList<>();
        while (listNode != null) {
            list2.add(listNode.val);
            listNode = listNode.next;
        }
        Assert.assertEquals(result, list2);
    }
}
