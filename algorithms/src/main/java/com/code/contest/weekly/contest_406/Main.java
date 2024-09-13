package com.code.contest.weekly.contest_406;

import com.code.problemset.ListNode;

import java.util.*;

public class Main {

    public static String getSmallestString(String s) {
        char[] array = s.toCharArray();
        String min = s;
        int a = 0,b = 0;
        int gap = Integer.MIN_VALUE;
        for (int i = 0; i < array.length - 1; i++) {
            if ((array[i] % 2) == (array[i + 1] % 2) && array[i] > array[i + 1]) {
                if (gap < array[i] - array[i + 1]) {
                    gap = Math.max(gap, array[i] - array[i + 1]);
                    a = i;
                    b = i + 1;
                    break;
                }
            }
        }
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        return min.compareTo(new String(array)) < 0 ? min : new String(array);
    }

    public static ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode newHead = new ListNode(0, head);
        ListNode pre = newHead;
        ListNode curr = newHead.next;
        while (curr != null) {
            // 断链
            if (set.contains(curr.val)) {
                pre.next = curr.next;
                curr = pre.next;
            } else {
                pre = curr;
                curr = curr.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        String s = "45320";
        System.out.println(getSmallestString(s));

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        int[] nums = {5};
        modifiedList(nums, head);
    }
}
