/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put('a' + i, 'a' + i);
            map.put('A' + i, 'a' + i);
        }
        for (int i = 0; i < 10; i++) {
            map.put('0' + i, '0' + i);
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            int chi = s.charAt(i);
            int chj = s.charAt(j);
            if (!map.containsKey(chi)) {
                i++;
            } else if (!map.containsKey(chj)) {
                j--;
            } else if (!map.get(chi).equals(map.get(chj))) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}

