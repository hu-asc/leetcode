package com.code.problemset.problem_23;

import com.code.problemset.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author huhongtao
 * @date 2024-10-22
 */
public class MergeKLists {

    /**
     * 将节点放入优先队列，按照头节点的 val 排序
     * 新增链表 newRoot
     * 
     * 遍历队列，将弹出的节点赋给 newRoot, 移动 curr 节点
     * 并将弹出的节点移动
     */
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode newRoot = new ListNode();
        ListNode curr = newRoot;
        while (!queue.isEmpty() && newRoot != null) {
            ListNode node = queue.poll();
            curr.next = node;
            curr = curr.next;
            node = node.next;
            if (node != null) {
                queue.add(node);
            }
        }
        return newRoot.next;
    }


    public ListNode mergeKListsV2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        return mergeTwoList(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    private ListNode mergeTwoList(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode newNode = new ListNode();
        ListNode curr = newNode;
        ListNode p1 = node1;
        ListNode p2 = node2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        // 剩余节点
        curr.next = p1 != null ? p1 : p2;
        return newNode.next;
    }

}
