package com.code.problemset.problem_50;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 * Constraints:
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 */
public class MyPow {

    /**
     * x^n拆成 x* x^(n-1),超时
     * 用快速幂方式,针对奇数需要特殊处理
     * 如果n为Integer.MIN_VALUE,直接-n会溢出
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1/x * myPow(1/x, -(n + 1));
        } else {
            return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
        }
    }

    /**
     * 迭代
     * @param x
     * @param n
     * @return
     */
    public double myPowV2(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double result = 1.0;
        if (b < 0) {
            b = -b;
            x = 1/x;
        }
        while (b > 0) {
            if ((b % 2) == 1) {
                result *= x;
            }
            x *= x;
            b >>= 1;
        }
        return result;
    }

}
