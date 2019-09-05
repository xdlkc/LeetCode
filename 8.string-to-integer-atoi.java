/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */
class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int flag = 1;
        String[] strings = str.split(" ");
        if (strings == null || strings.length <= 0) {
            return 0;
        }
        String s = null;
        for (int i = 0; i < strings.length; i++) {
            if (!strings[i].equals("")) {
                s = strings[i];
                break;
            }
        }
        if (s == null || s.equals("")) {
            return 0;
        }
        if (s.charAt(0) == '-') {
            flag = -1;
            s = s.substring(1, s.length());
        }
        int sum = 0;
        int m = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') {
                return 0;
            }
            if (flag == 1) {
                if (Integer.MAX_VALUE - m * (ch - '0') < sum) {
                    return Integer.MAX_VALUE;
                }
            } else {
                if (Integer.MIN_VALUE + m * (ch - '0') > flag * sum) {
                    return Integer.MIN_VALUE;
                }
            }
            sum += m * (ch - '0');
            m *= 10;
        }
        return flag * sum;
    }
}
