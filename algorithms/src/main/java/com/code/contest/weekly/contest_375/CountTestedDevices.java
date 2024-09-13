package com.code.contest.weekly.contest_375;

public class CountTestedDevices {
    public int countTestedDevices(int[] batteryPercentages) {
        int n = batteryPercentages.length;
        int res = 0;
        int minusCount = 0;
        for (int i = 0; i < n; i++) {
            if (batteryPercentages[i] == 0) {
                continue;
            }
            if (batteryPercentages[i] - minusCount > 0) {
                res++;
                minusCount++;
            }
        }
        return res;
    }
}
