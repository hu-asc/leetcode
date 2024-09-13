package com.code.problemset.problem_206;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseListTest {


    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseList solution = new ReverseList();
        List<Integer> result = Arrays.asList(5, 4, 3, 2, 1);
        ListNode listNode = solution.reverseList(head);
        List<Integer> result1 = new ArrayList<>();
        while (listNode != null) {
            result1.add(listNode.val);
            listNode = listNode.next;
        }
        Assert.assertEquals(result, result1);

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode2 = solution.reverseListV2(head);
        List<Integer> result2 = new ArrayList<>();
        while (listNode2 != null) {
            result2.add(listNode2.val);
            listNode2 = listNode2.next;
        }
        Assert.assertEquals(result, result2);
    }
}
