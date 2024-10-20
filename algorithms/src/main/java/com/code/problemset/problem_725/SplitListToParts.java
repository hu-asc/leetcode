package com.code.problemset.problem_725;

import com.code.problemset.ListNode;

import java.util.Arrays;

/**
 * @author huhongtao
 * @date 2024-10-19
 */
public class SplitListToParts {

    /**
     * 获取链表数量 count
     *
     * 分成 k 份，每份是 count / k
     * 然后前 count % k份在都 + 1
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        int avg = count / k;
        int mod = count % k;
        int[] perCountArray = new int[k];
        Arrays.fill(perCountArray, avg);
        Arrays.fill(perCountArray, 0, mod, avg + 1);
        ListNode[] result = new ListNode[k];
        ListNode tmp = head;
        for (int i = 0; i < perCountArray.length; i++) {
            ListNode newNode = new ListNode();
            ListNode tail = newNode;
            for (int j = 0; j < perCountArray[i]; j++) {
                tail.next = new ListNode(tmp.val);
                tail = tail.next;
                tmp = tmp.next;
            }
            result[i] = newNode.next;
        }
        return result;
    }

    /**
     * 也可以修改原链表实现
     */
    public ListNode[] splitListToPartsV2(ListNode head, int k) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        int avg = count / k;
        int mod = count % k;
        int[] perCountArray = new int[k];
        Arrays.fill(perCountArray, avg);
        Arrays.fill(perCountArray, 0, mod, avg + 1);
        ListNode[] result = new ListNode[k];

        node = head;
        ListNode prev = node;
        for (int i = 0; i < perCountArray.length; i++) {
            ListNode newNode = node;
            while (perCountArray[i]-- > 0) {
                prev = node;
                node = node.next;
            }
            if (prev != null) {
                prev.next = null;
            }
            result[i] = newNode;
        }
        return result;
    }

}
