package com.code.problemset;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huhongtao
 * @date 2024-10-20
 */
public class ListNodeUtil {

    private ListNodeUtil(){}

    public static ListNode toListNode(int[] nums) {
        ListNode head = new ListNode();
        ListNode curr = head;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return head.next;
    }

    public static int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

}
