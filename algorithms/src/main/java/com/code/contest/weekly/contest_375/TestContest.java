package com.code.contest.weekly.contest_375;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestContest {

    @Test
    public void countTestedDevicesTest() {
        CountTestedDevices countTestedDevices = new CountTestedDevices();

        int[] batteryPercentages = new int[]{1,1,2,1,3};
        int result = 3;
        Assert.assertEquals(countTestedDevices.countTestedDevices(batteryPercentages), result);

        batteryPercentages = new int[]{0,1,2};
        result = 2;
        Assert.assertEquals(countTestedDevices.countTestedDevices(batteryPercentages), result);
    }


    @Test
    public void getGoodIndicesTest() {
        GetGoodIndices getGoodIndices = new GetGoodIndices();

        int[][] variables = new int[][]{{2,3,3,10}, {3,3,3,1}, {6,1,1,4}};
        int target = 2;
        Assert.assertEquals(getGoodIndices.getGoodIndices(variables, target), Arrays.asList(0, 2));

        variables = new int[][]{{39,3,1000,1000}};
        target = 17;
        Assert.assertEquals(getGoodIndices.getGoodIndices(variables, target), Arrays.asList());
    }

    @Test
    public void countSubarraysTest() {
        CountSubarrays countSubarrays = new CountSubarrays();

        int[] nums = new int[]{1,3,2,3,3};
        int k = 2;
        long result = 6;
        Assert.assertEquals(countSubarrays.countSubarrays(nums, k), result);

        nums = new int[]{1,4,2,1};
        k = 3;
        result = 0;
        Assert.assertEquals(countSubarrays.countSubarrays(nums, k), result);
    }

    @Test
    public void numberOfGoodPartitionsTest() {
        NumberOfGoodPartitions numberOfGoodPartitions = new NumberOfGoodPartitions();

        int[] nums = new int[]{1, 2, 3, 4};
        int result = 8;
        Assert.assertEquals(numberOfGoodPartitions.numberOfGoodPartitions(nums), result);
        Assert.assertEquals(numberOfGoodPartitions.numberOfGoodPartitionsV2(nums), result);

        nums = new int[]{1,1,1,1};
        result = 1;
        Assert.assertEquals(numberOfGoodPartitions.numberOfGoodPartitions(nums), result);
        Assert.assertEquals(numberOfGoodPartitions.numberOfGoodPartitionsV2(nums), result);

        nums = new int[]{1,2,1,3};
        result = 2;
        Assert.assertEquals(numberOfGoodPartitions.numberOfGoodPartitions(nums), result);
        Assert.assertEquals(numberOfGoodPartitions.numberOfGoodPartitionsV2(nums), result);
    }
}
