/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 1;
        while (i < height.length) {
            for (int j = 0; j < height.length; j++) {
                for (int k = i + j; k < height.length; k+=i) {
                    int tmp = Math.min(height[j], height[k]) * i;
                    if (tmp > max) {
                        max = tmp;
                    }
                }
            }
            i += 1;
        }
        return max;
    }
}

