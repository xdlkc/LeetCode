/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */
class Solution {
    public int search(int[] nums, int target) {
        int hi = nums.length - 1;
        int lo = 0;
        while(lo < hi) {
            int i = (hi + lo) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[i]) ^ (target > nums[i]))  {
                lo = i + 1;
            }  else{
                hi = i;
            }
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }
}

