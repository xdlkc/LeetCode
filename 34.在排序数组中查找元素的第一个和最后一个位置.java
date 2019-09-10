/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] err = new int[] {-1, -1};
        if (nums.length == 0) {
            return err;
        }
        int l = extremeInsertionIndex(nums, target, true);
        if (l == nums.length || nums[l] != target) {
            return err;
        }
        int r = extremeInsertionIndex(nums, target, false) - 1;
        return new int[] {l, r};
    }
    public int[] binarySearch(int[] nums, int target, int i, int j) {
        if (i == j) {
            if (nums[i] != target) {
                return  new int[] {-1, -1};
            }
        }
        if (nums[i] == target && nums[j] == target) {
            while (i >= 0 && nums[i] == target) {
                i--;
            }
            while (j < nums.length && nums[j] == target) {
                j++;
            }
            return new int[]{i+1, j-1};
        }
        int mid = (i + j) / 2;
        if (nums[mid] >= target) {
            return binarySearch(nums, target, i, mid);
        } else {
            return binarySearch(nums, target, mid+1, j); 
        }
    }
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}

