package com.code.problemset.problem_231;

public class IsPowerOfTwo {

    /**
     * 2的幂能整除2
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        return n % 2 == 0 ? isPowerOfTwo(n / 2) : false;
    }

    /**
     * 只有1个位为1
     */
    public boolean isPowerOfTwoV2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
