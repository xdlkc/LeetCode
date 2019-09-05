/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */
class Solution {
    public int maxSubArray(int[] nums) {
        return dpFun(nums);
    }

    public int dpFun(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = 0;
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}
