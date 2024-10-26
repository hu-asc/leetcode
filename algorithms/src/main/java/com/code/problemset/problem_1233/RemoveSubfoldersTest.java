package com.code.problemset.problem_1233;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author huhongtao
 * @date 2024-10-25
 */
public class RemoveSubfoldersTest {

    @Test
    public void test() {
        RemoveSubfolders removeSubfolders = new RemoveSubfolders();

        String[] folder = new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"};
        List<String> expected = Arrays.asList("/a", "/c/d", "/c/f");

        List<String> result = removeSubfolders.removeSubfolders(folder);
        Assert.assertEquals(expected, result);

        result = removeSubfolders.removeSubfoldersV2(folder);
        Assert.assertEquals(expected, result);
    }
}
