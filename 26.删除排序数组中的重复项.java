/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int len = nums.length;
        while (i < len) {
            int j = i;
            while (j < len - 1 && nums[j] == nums[j + 1]) {
                j++;
            }
            if (j != i) {
                for (int k = j + 1; k < len; k++) {
                    nums[k - (j - i)] = nums[k];
                }
            }
            len = len - (j - i);
            i++;
        }
        return len;
    }
}
