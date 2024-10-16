package com.code.problemset.problem_2491;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-16
 */
public class DividePlayersTest {

    @Test
    public void test() {
        DividePlayers dividePlayers = new DividePlayers();
        int[] skill = new int[]{3,2,5,1,3,4};
        long expected = 22;
        long result = dividePlayers.dividePlayers(skill);
        Assert.assertEquals(expected, result);

        skill = new int[]{3,4};
        expected = 12;
        result = dividePlayers.dividePlayers(skill);
        Assert.assertEquals(expected, result);

        skill = new int[]{1,1,2,3};
        expected = -1;
        result = dividePlayers.dividePlayers(skill);
        Assert.assertEquals(expected, result);
    }
}
