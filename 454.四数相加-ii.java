/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> abMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (abMap.containsKey(sum)) {
                    int t = abMap.get(sum);
                    abMap.put(sum, t+1);
                } else {
                    abMap.put(sum, 1);
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                if (abMap.containsKey(-1 * sum)) {
                    int v = abMap.get(-1 * sum);
                    cnt += v;
                }
            }
        }
        return cnt;
    }
}

