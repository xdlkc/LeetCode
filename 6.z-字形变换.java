/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */
class Solution {
    public String convert(String s, int numRows) {
        if (s == null) {
            return s;
        }
        if(numRows <= 1) {
            return s;
        }
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }
        int i = 0;
        int flag = 0;
        for (int k = 0; k < s.length(); k++) {
            String tmp = String.valueOf(s.charAt(k));
            builders[i].append(tmp);
            if (flag == 0) {
                if(i == numRows - 1) {
                    flag = -1;
                    i--;
                } else {
                    i++;
                }
            } else {
                if (i == 0) {
                    flag = 0;
                    i++;
                } else {
                    i--;
                }
            }
        }
        StringBuilder nbuilder = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            nbuilder.append(builders[j].toString());
        }
        return nbuilder.toString();
    }
}
