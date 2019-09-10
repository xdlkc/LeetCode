/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */
class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            int tmp = Math.min(height[i], height[j]) * (j- i);
            if (tmp > max) {
                max = tmp;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public int exhasutive(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int sum = Math.min(height[i], height[j]) * (j - i);
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}

