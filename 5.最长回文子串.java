/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */
class Solution {

    public String longestPalindrome(String s) {
        return centerExpandFun(s);
    }

    private String dpFun(String s) {
        if (s == null || s.length() <= 0) {
            return "";
        }
        int tmpLen = 0;
        int tmpI = -1;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                int c = s.length() - 1 - j;
                if (s.charAt(i) == s.charAt(c)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    if (tmpLen < dp[i][j]) {
                        int beforeRev = s.length() - 1 - j;
                        if (beforeRev + dp[i][j] - 1 == i) {
                            tmpLen = dp[i][j];
                            tmpI = i;
                        }
                    }
                }
            }
        }
        return s.substring(tmpI - tmpLen + 1, tmpI + 1);
    }

    private String centerExpandFun(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int i1 = expandCenter(s, i, i);
            int i2 = expandCenter(s, i, i + 1);
            i1 = i1 > i2 ? i1 : i2;
            if (i1 > (end - start + 1)) {
                start = i - (i1 - 1) / 2;
                end = i + i1 / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandCenter(String s, int i, int j) {
        int L = i;
        int R = j;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^";
        for (int i = 0; i < n; i++)
            ret += "#" + s.charAt(i);
        ret += "#$";
        return ret;
    }

    public String manacherFun(String s) {
        String ps = preProcess(s);
        int center = 0;
        int right = 0;
        int[] P = new int[ps.length()];

        int start = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < P.length; i++) {
            if (max < P[i]) {
                start = 
            }
        }
        return "";
    }
}
