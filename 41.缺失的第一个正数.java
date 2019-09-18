/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean f = false;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                f = true;
                break;
            }
        }
        if (!f) {
            return 1;
        }
        if (nums.length == 1) {
            return 2;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        int tmp = 1;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (index == n) {
                nums[0] = - Math.abs(nums[0]);
            } else {
                nums[index] = - Math.abs(nums[index]);
            }
            
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            } 
        }
        if (nums[0] > 0) {
            return n;
        }
        return n+1;
    }
}

