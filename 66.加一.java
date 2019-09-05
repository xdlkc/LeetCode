/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int flag = 1;
        StringBuilder builder = new StringBuilder();
        for (int i = digits.length-1; i >= 0; i--) {
            int tmp = digits[i] + flag;
            if (tmp > 9) {
                flag = 1;
                tmp %= 10;
            } else {
                flag = 0;
            }
            builder.append(tmp);
        }
        if (flag == 1) {
            builder.append(1);
        }
        String s = builder.toString();
        int[] result = new int[s.length()];
        for(int i = s.length()-1; i >= 0; i--) {
            result[s.length()-1-i] = s.charAt(i) - '0';
        }
        return result;
    }
}

