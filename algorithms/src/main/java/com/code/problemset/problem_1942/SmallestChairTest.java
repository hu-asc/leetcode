package com.code.problemset.problem_1942;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-15
 */
public class SmallestChairTest {

    @Test
    public void test() {
        SmallestChair smallestChair = new SmallestChair();
        int[][] times = new int[][]{{1,4},{2,3},{4,6}};
        int targetFriend = 1;
        int result = smallestChair.smallestChair(times, targetFriend);
        int expected = 1;
        Assert.assertEquals(expected, result);

        times = new int[][]{{1,4},{2,3},{4,6}};
        result = smallestChair.smallestChairV2(times, targetFriend);
        Assert.assertEquals(expected, result);

        times = new int[][]{{3,10},{1,5},{2,6}};
        targetFriend = 0;
        expected = 2;
        result = smallestChair.smallestChair(times, targetFriend);
        Assert.assertEquals(expected, result);

        times = new int[][]{{3,10},{1,5},{2,6}};
        result = smallestChair.smallestChairV2(times, targetFriend);
        Assert.assertEquals(expected, result);
    }
}
