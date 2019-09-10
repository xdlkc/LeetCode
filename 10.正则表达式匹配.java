/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */
class Solution {
    public boolean isMatch(String s, String p) {


    }
    public boolean isMatch(String s, String p, int start, int end) {
        char a = '.';
        char b = '*';
        int i = start;
        int j = end;
        while (i < j && i < p.length() && (s.charAt(i) == p.charAt(i) || p.charAt(i) == a)) {
            i++;
        } 
        if (i == s.length() && i == p.length()) {
            return true;
        }
        if (i == s.length() ^ i == p.length()) {
            if (i == p.length()) {
                return false;
            }
            while (i < p.length()) {
                if (p.charAt(i) != b) {
                    return false;
                }
                i++;
            }
            return true;
        }
    }
}

