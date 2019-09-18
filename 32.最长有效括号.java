/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2 + (i < 2 ? 0 : dp[i - 2]);
                } else {
                    if (i - dp[i - 1] > 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                        dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] > 1 ? dp[i - 2 - dp[i - 1]] : 0);
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
