/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > min) {
                if (sum < prices[i] - min) {
                    sum = prices[i] - min;
                }
            } else {
                min = prices[i];
            }
        }
        return sum;
    }
}

