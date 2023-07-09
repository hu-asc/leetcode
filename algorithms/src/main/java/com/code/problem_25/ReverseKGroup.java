package com.code.problem_25;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * Follow up:
 * Could you solve the problem in O(1) extra memory space?
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 * Constraints:
 * The number of nodes in the list is in the range sz.
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode begin;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        begin = dummyHead;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 翻转start->end
     */
    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode prev = begin;
        ListNode curr = begin.next;
        ListNode first = curr;
        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // 翻转后的链表保存关系
        begin.next = prev;
        first.next = curr;
        return first;
    }


    public ListNode reverseKGroupV2(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        // 翻转前k个节点
        ListNode newHead = reverseV2(head, tail);
        // 下一次递归开始的节点tail
        head.next = reverseKGroupV2(tail, k);
        return newHead;
    }

    private ListNode reverseV2(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode next = null;
        while (head != tail) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}

class ListNode {

    int val;

    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}