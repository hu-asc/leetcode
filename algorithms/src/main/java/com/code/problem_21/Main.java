package com.code.problem_21;

import com.code.ListNode;

public class Main {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        MergeTwoLists t = new MergeTwoLists();
        ListNode listNode = t.mergeTwoListsV2(head1, head2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
