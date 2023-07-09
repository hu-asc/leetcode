package com.code.problem_231;

import org.junit.Test;

public class IsPowerOfTwoTest {

    @Test
    public void test() {
        IsPowerOfTwo isPowerOfTwo = new IsPowerOfTwo();
        int n = 15;
        System.out.println(isPowerOfTwo.isPowerOfTwo(n));
        System.out.println(isPowerOfTwo.isPowerOfTwoV2(n));
    }
}
