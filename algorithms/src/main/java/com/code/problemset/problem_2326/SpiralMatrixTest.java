package com.code.problemset.problem_2326;

import com.code.problemset.ListNode;
import com.code.problemset.ListNodeUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-20
 */
public class SpiralMatrixTest {

    @Test
    public void test() {
        SpiralMatrix spiralMatrix = new SpiralMatrix();

        int m = 3;
        int n = 5;
        int[] nums = new int[]{3,0,2,6,8,1,7,9,4,2,5,5,0};
        ListNode head = ListNodeUtil.toListNode(nums);
        int[][] expected = new int[][]{{3,0,2,6,8},{5,0,-1,-1,1},{5,2,4,9,7}};
        int[][] result = spiralMatrix.spiralMatrix(m, n, head);
        Assert.assertArrayEquals(expected, result);

        m = 1;
        n = 4;
        nums = new int[]{0, 1, 2};
        head = ListNodeUtil.toListNode(nums);
        expected = new int[][]{{0, 1, 2, -1}};
        result = spiralMatrix.spiralMatrix(m, n, head);
        Assert.assertArrayEquals(expected, result);
    }
}
