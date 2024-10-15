package com.code.problemset.problem_2938;

public class MinimumSteps {

    /**
     * currPosition 表示当前指针
     * writePosition 表示白球写入位置
     * 
     * 当前位置为 0 时,需要交换,并右移白球写入位置
     */
    public long minimumSteps(String s) {
        int writePosition = 0;
        long swapCount = 0;
        for (int currPosition = 0; currPosition < s.length(); currPosition++) {
            if (s.charAt(currPosition) == '0') {
                // 计算交换次数,并右移 writePosition
                swapCount += currPosition - writePosition;
                writePosition++;
            }
        }
        return swapCount;
    }

    /**
     * 白球左移次数就是黑球数量
     */
    public long minimumStepsV2(String s) {
        long swapCount = 0;
        int blackCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                blackCount++;
            } else if (s.charAt(i) == '0') {
                swapCount += blackCount;
            }
        }
        return swapCount;
    }

}
