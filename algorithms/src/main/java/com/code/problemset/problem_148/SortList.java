package com.code.problemset.problem_148;

import com.code.problemset.ListNode;

public class SortList {

    /**
     * 找出中间节点,然后递归排序两部分
     */
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode l1 = sortList(head, mid);
        ListNode l2 = sortList(mid, tail);
        ListNode merge = merge(l1, l2);
        return merge;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyListNode = new ListNode(0);
        ListNode prev = dummyListNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return dummyListNode.next;
    }


    /**
     *
     * @param head
     * @return
     */
    public ListNode sortListV2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyNode = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength = subLength * 2) {
            ListNode prev = dummyNode, curr = dummyNode.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                // 第二个链表结束位置
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyNode.next;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next = new ListNode(190);

        SortList t = new SortList();
        ListNode listNode = t.sortList(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

}
