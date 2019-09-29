import java.util.Stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */
class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        int ans = 0;
        while (curr < height.length) {
            while (!stack.isEmpty() && height[curr] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int h = Math.min(height[curr], height[stack.peek()]) - height[top];
                ans += (curr - stack.peek() - 1) * h;
            }
            stack.push(curr++);
        }
        return ans;
    }
    public int normalFunction(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(height[j], maxLeft);
            }
            for (int j = i; j < height.length; j++) {
                maxRight = Math.max(height[j], maxRight);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }
}
