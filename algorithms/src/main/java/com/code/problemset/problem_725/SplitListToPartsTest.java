package com.code.problemset.problem_725;

import com.code.problemset.ListNode;
import com.code.problemset.ListNodeUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-19
 */
public class SplitListToPartsTest {

    @Test
    public void test() {
        SplitListToParts splitListToParts = new SplitListToParts();

        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        ListNode head = ListNodeUtil.toListNode(nums);
        int k = 3;
        int[][] expected = new int[][]{{1,2,3,4},{5,6,7},{8,9,10}};
        ListNode[] listNodes = splitListToParts.splitListToParts(head, k);
        int[][] result = new int[3][];
        for (int i = 0; i < listNodes.length; i++) {
            int[] array = ListNodeUtil.toArray(listNodes[i]);
            result[i] = array;
        }
        Assert.assertArrayEquals(expected, result);

        listNodes = splitListToParts.splitListToPartsV2(head, k);
        result = new int[3][];
        for (int i = 0; i < listNodes.length; i++) {
            int[] array = ListNodeUtil.toArray(listNodes[i]);
            result[i] = array;
        }
        Assert.assertArrayEquals(expected, result);
    }
}
