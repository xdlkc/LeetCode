/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int i = 1;
        while(true) {
            if (i == x / i) {
                return i;
            }
            if(i > x / i) {
                break;
            }
            i++;
        }
        return i-1;
    }
}

