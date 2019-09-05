/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int sum = 0;
        int i = 0;
        while (i < height.length) {
            int j = i + 1;
            int tmp = 0;
            while (j < height.length && height[i] > height[j]) {
                tmp += (height[i] - height[j]);
                j++;
            }
            if (j < height.length) {
                sum += tmp;
            }
            i = j;
        }
        return sum;
    }
}
