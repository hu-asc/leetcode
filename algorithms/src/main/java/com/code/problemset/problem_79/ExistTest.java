package com.code.problemset.problem_79;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-22
 */
public class ExistTest {

    @Test
    public void test() {
        Exist exist = new Exist();

        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean expected = true;
        boolean result = exist.exist(board, word);
        Assert.assertEquals(expected, result);
    }
}
