/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */
class Solution {
    public int climbStairs(int n) {
        if (n==1) {
            return 1;
        }
        int[] dp = new int[n];
        int a = 1;
        int b = 2;
        while(n > 2) {
            int c = a + b;
            a = b;
            b = c;
            n--;
        }
        return b;
    }
}

