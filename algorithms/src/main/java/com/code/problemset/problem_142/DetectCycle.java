package com.code.problemset.problem_142;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 * following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 * Notice that you should not modify the linked list.
 *
 * Constraints:
 * The number of the nodes in the list is in the range [0, 10^4].
 * -10^5 <= Node.val <= 10^5
 * pos is -1 or a valid index in the linked-list.
 */
public class DetectCycle {


    /**
     * 保存遍历节点
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }


    /**
     *
     * 快慢指针在环中相遇，设从头节点到环入口处p的距离为a, 在距离p处b距离的q点处相遇，剩余环的距离为b（p到q）
     * 2 * (a + b) = a + 2b + c  ---> a = c
     * 所以当快慢指针相遇时，从头节点遍历另一指针，慢指针继续遍历，相遇处即为入口处
     */
    public ListNode detectCycleV2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode other = head;
                while (other != slow) {
                    other = other.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
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
