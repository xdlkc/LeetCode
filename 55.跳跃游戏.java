/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int index = nums.length - 1;
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] + i >= index) {
                index = i;
            }
            i--;
        }
        return index == 0;
    }
    public boolean fun(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (dp[i] != 1) {
                continue;
            }
            if (i > 0 && nums[i] < nums[i - 1]) {
                continue;
            }
            int tmp = nums[i];
            if (tmp >= nums.length - i - 1) {
                return true;
            }
            while (tmp > 0) {
                if (nums[i + tmp] >= nums.length - (i + tmp) - 1) {
                    return true;
                }
                dp[i + tmp] = 1;
                tmp--;
            }
        }
        return false;
    }
}
