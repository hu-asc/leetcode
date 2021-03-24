package com.code.problem_141;

import java.util.HashSet;
import java.util.Set;


/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Constraints:
 * The number of the nodes in the list is in the range [0, 10^4].
 * -10^5 <= Node.val <= 10^5
 * pos is -1 or a valid index in the linked-list.
 */
public class HasCycle {

    /**
     * hash/set保存遍历的节点
     */
    public boolean hasCycle(ListNode head) {
        Set<Integer> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.contains(head.val)) {
                return true;
            } else {
                nodes.add(head.val);
            }
            head = head.next;
        }
        return false;
    }


    /**
     * 快慢指针
     * slow 一步
     * fast 两步
     */
    public boolean hasCycleV2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HasCycle t = new HasCycle();
        ListNode node = new ListNode(3);
//        ListNode secondNode = new ListNode(2);
//        node.next = secondNode;
//        node.next.next = new ListNode(0);
//        ListNode lastNode = new ListNode(-4);
//        node.next.next.next = lastNode;
//        lastNode.next = secondNode;
        boolean b = t.hasCycle(node);
        System.out.println(b);

    }
}


class ListNode {

    int val;

    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(ListNode next) {
        this.val = val;
        this.next = next;
    }
}