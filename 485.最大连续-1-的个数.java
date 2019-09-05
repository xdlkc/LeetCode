/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续1的个数
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int i = 0;
        while (i < nums.length) {
            int tmp = 0;
            while (i < nums.length && nums[i] == 1) {
                tmp++;
                i++;
            }
            if (tmp > sum) {
                sum = tmp;
            }
            i++;
        }
        return sum;
    }
}
