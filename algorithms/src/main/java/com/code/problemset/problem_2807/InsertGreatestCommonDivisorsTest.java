package com.code.problemset.problem_2807;

import com.code.problemset.ListNode;
import com.code.problemset.ListNodeUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-20
 */
public class InsertGreatestCommonDivisorsTest {

    @Test
    public void test() {
        InsertGreatestCommonDivisors insertGreatestCommonDivisors = new InsertGreatestCommonDivisors();

        int[] nums = new int[]{18,6,10,3};
        ListNode head = ListNodeUtil.toListNode(nums);
        ListNode listNode = insertGreatestCommonDivisors.insertGreatestCommonDivisors(head);
        int[] result = ListNodeUtil.toArray(listNode);
        int[] expected = new int[]{18,6,6,2,10,1,3};
        Assert.assertArrayEquals(expected, result);

        nums = new int[]{7};
        head = ListNodeUtil.toListNode(nums);
        listNode = insertGreatestCommonDivisors.insertGreatestCommonDivisors(head);
        result = ListNodeUtil.toArray(listNode);
        expected = new int[]{7};
        Assert.assertArrayEquals(expected, result);
    }
}
