/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */
class Solution {
    public int divide(int dividend, int divisor) {
        long y = Math.abs((long) dividend);
        long x = Math.abs((long) divisor);
        long cnt = 0;
        while (y >= x) {
            int c = 1;
            while (y >= (x << c)) {
                c++;
            }
            cnt += ((long) 1 << (c-1));
            y -= (x << (c-1));
        }
        if (dividend > 0 ^ divisor > 0) {
            cnt = -cnt;
        }
        if (cnt >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (cnt <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) cnt;
    }
}
