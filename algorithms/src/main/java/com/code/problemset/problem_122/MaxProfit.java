package com.code.problemset.problem_122;

public class MaxProfit {

    /**
     * 贪心
     * 可以交易无数次,只要后一天大于前一天就可以卖出
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = new int[]{7,1,5,3,6,4};
        int i = maxProfit.maxProfit(prices);
        System.out.println(i);
    }
}
