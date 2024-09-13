package com.code.problemset.problem_860;

public class LemonadeChange {

    /**
     * 贪心
     * 两个变量维护$5,$10的数量，先用最大的面额找零
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                five--;
                ten++;
            } else if (ten > 0) {
                ten--;
                five--;
            } else {
                five -= 3;
            }
            if (five < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange lemonadeChange = new LemonadeChange();
        int[] bills = new int[]{10, 10};
        System.out.println(lemonadeChange.lemonadeChange(bills));
    }
}
