package com.code.problemset.problem_3217;

import com.code.problemset.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huhongtao
 * @date 2024-10-19
 */
public class ModifiedListTest {

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ModifiedList modifiedList = new ModifiedList();
        int[] nums = new int[]{1,2,3};
        ListNode listNode = modifiedList.modifiedList(nums, head);
        List<Integer> result = new ArrayList<>();
        while (listNode != null) {
            result.add(listNode.val);
            listNode = listNode.next;
        }
        List<Integer> expected = Arrays.asList(4, 5);
        Assert.assertEquals(expected, result);

        listNode = modifiedList.modifiedListV2(nums, head);
        result = new ArrayList<>();
        while (listNode != null) {
            result.add(listNode.val);
            listNode = listNode.next;
        }
        expected = Arrays.asList(4, 5);
        Assert.assertEquals(expected, result);
    }
}
