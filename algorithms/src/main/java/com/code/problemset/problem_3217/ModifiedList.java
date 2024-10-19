package com.code.problemset.problem_3217;

import com.code.problemset.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huhongtao
 * @date 2024-10-19
 */
public class ModifiedList {

    /**
     * 新增一个 newHead 节点
     *
     * 遍历原链表，判断 val 是否存在
     * 如果不存在，将值为 val 的节点添加到 newHead 上
     */
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode newHead = new ListNode();
        ListNode node = head;
        ListNode newNode = newHead;
        while (node != null) {
            if (!set.contains(node.val)) {
                newNode.next = new ListNode(node.val);
                newNode = newNode.next;
            }
            node = node.next;
        }
        return newHead.next;
    }


    /**
     * 可以在原链表处理
     */
    public ListNode modifiedListV2(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // 根节点是否需要删除
        while (head != null && set.contains(head.val)) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode current = head;
        while (current.next != null) {
            if (set.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

}