/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        String s = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String curStr = strs[i];
            int len = s.length();
            if (s.length() > curStr.length()) {
                len = curStr.length();
            }
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < len; j++) {
                if (s.charAt(j) != curStr.charAt(j)) {
                    break;
                }
                builder.append(s.charAt(j));
            }
            s = builder.toString();
        }
        return s;
    }
}
