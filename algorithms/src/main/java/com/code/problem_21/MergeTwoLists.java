package com.code.problem_21;

import com.code.ListNode;

public class MergeTwoLists {

    /**
     * 较小节点优先放入
     */
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(0);
        ListNode prev = dummyNode;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                prev.next = head1;
                head1 = head1.next;
            } else {
                prev.next = head2;
                head2 = head2.next;
            }
            prev = prev.next;
        }
        // 处理剩余链表
        prev.next = head1 == null ? head2 : head1;
        return dummyNode.next;
    }


    /**
     * l1和l2的较小节点和其余节点进行递归合并
     */
    public ListNode mergeTwoListsV2(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        } else if (head1.val < head2.val) {
            head1.next = mergeTwoListsV2(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoListsV2(head1, head2.next);
            return head2;
        }
    }

}
