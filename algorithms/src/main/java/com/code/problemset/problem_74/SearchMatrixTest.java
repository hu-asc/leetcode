package com.code.problemset.problem_74;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-23
 */
public class SearchMatrixTest {

    @Test
    public void test() {
        SearchMatrix searchMatrix = new SearchMatrix();
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        boolean expected = true;

        boolean result = searchMatrix.searchMatrix(matrix, target);
        Assert.assertEquals(expected, result);

        result = searchMatrix.searchMatrixV2(matrix, target);
        Assert.assertEquals(expected, result);
    }
}
