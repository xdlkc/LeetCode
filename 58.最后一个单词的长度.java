/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int len = 0;
        boolean flag = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && flag) {
                break;
            }
            if (s.charAt(i) != ' ') {
                flag = true;
                len++;
            }
        }
        return len;
    }
}
