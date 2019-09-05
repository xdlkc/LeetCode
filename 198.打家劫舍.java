/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 < 0) {
                dp[i] = nums[i];
            } else if (i - 2 < 0) {
                dp[i] = Math.max(dp[i - 1], nums[i]);
            } else {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }

            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

}
