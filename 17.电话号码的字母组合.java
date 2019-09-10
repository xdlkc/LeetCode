/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        String[] charts = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new LinkedList<>();
        for (int i = 0; i < digits.length(); i++) {
            String chart = charts[digits.charAt(i)-'2'];
            if (list.isEmpty()) {
                for (int j = 0; j < chart.length(); j++) {
                    list.add(String.valueOf(chart.charAt(j)));
                }
            } else {
                List<String> tmpList = new LinkedList<>();
                for (String s : list) {
                    for (int j = 0; j < chart.length(); j++) {
                        tmpList.add(s+String.valueOf(chart.charAt(j)));
                    }
                }
                list = tmpList;
            }
        }
        return list;
    }
}

