/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int[] next = buildNext(needle);
        int j = 0;
        int i = 0;
        while(i < haystack.length() && j < needle.length()) {
            if(j==-1||haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length()) {
            return i - needle.length();
        } else {
            return -1;
        }
    }
    public int[] buildNext(String s) {
        int[] next = new int[s.length()];
                next[0] = -1;
                int i = 0;
                int k = -1;
                while(i < s.length()-1 ) {
                    if(k == -1 || s.charAt(k) == s.charAt(i)) {
                        ++k;
                        ++i;
                        next[i] = k;
                    } else{
                        k = next[k];
                    }
                }
                return next;
    }
}

