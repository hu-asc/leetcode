package com.code.problemset.problem_2807;

import com.code.problemset.ListNode;

/**
 * @author huhongtao
 * @date 2024-10-20
 */
public class InsertGreatestCommonDivisors {

    /**
     * 需要保存两个节点 prev, curr
     * 求最大公约数，然后在 prev 和 curr 之间新增节点
     */
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = curr;
        while (curr.next != null) {
            prev = curr;
            curr =  curr.next;
            int i = getGCD(prev.val, curr.val);
            ListNode listNode = new ListNode(i);
            prev.next = listNode;
            listNode.next = curr;
        }
        return head;
    }

    /**
     * 获取最大公约数
     *
     * 用较大的数除以较小的数，得到余数。
     * 用较小的数替换较大的数，用余数替换较小的数。
     * 重复步骤1和步骤2，直到余数为0。
     * 此时较小的数即为最大公约数。
     */
    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
