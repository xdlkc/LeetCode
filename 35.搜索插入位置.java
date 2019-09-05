/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] >= target) {
                return 0;
            } else {
                return 1;
            }
        }
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    public int searchInsert(int[] nums, int target, int start, int end) {
        if (end < 0) {
            return 0;
        }
        if (start > end) {
            return start;
        }
        if (start == end) {

            if (nums[start] >= target) {
                return start;
            } else {
                return start + 1;
            }
        }
        int index = (start + end) / 2;
        int v = nums[index];
        if (v == target) {
            return index;
        } else if (v > target) {
            return searchInsert(nums, target, start, index - 1);
        } else {
            return searchInsert(nums, target, index + 1, end);
        }
    }
}
