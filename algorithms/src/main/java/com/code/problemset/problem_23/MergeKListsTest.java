package com.code.problemset.problem_23;

import com.code.problemset.ListNode;
import com.code.problemset.ListNodeUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-22
 */
public class MergeKListsTest {

    @Test
    public void test() {
        MergeKLists mergeKLists = new MergeKLists();

        ListNode[] lists = new ListNode[3];
        int[] nums0 = new int[]{1, 4, 5};
        lists[0] = ListNodeUtil.toListNode(nums0);
        int[] nums1 = new int[]{1,3,4};
        lists[1] = ListNodeUtil.toListNode(nums1);
        int[] nums2 = new int[]{2,6};
        lists[2] = ListNodeUtil.toListNode(nums2);
        int[] expected = new int[]{1,1,2,3,4,4,5,6};

        ListNode result = mergeKLists.mergeKLists(lists);
        int[] array = ListNodeUtil.toArray(result);
        Assert.assertArrayEquals(expected, array);

        lists[0] = ListNodeUtil.toListNode(nums0);
        lists[1] = ListNodeUtil.toListNode(nums1);
        lists[2] = ListNodeUtil.toListNode(nums2);
        result = mergeKLists.mergeKListsV2(lists);
        array = ListNodeUtil.toArray(result);
        Assert.assertArrayEquals(expected, array);
    }
}
