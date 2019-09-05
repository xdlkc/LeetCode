/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */
class Solution {
    private int[] cols;
    private int[] mainDiag;
    private int[] secondDiag;
    private int n;
    List<List<String>> output;
    int queens[];

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        cols = new int[n];
        mainDiag = new int[2 * n - 1];
        secondDiag = new int[2 * n - 1];
        output = new LinkedList<>();
        queens = new int[n];
        backtrack(0);
        return output;
    
    }
    // 修改校验数组
    public void placeQueen(int i, int j) {
        cols[j] = 1;
        mainDiag[i - j + n - 1] = 1;
        secondDiag[i + j] = 1;
        queens[i] = j;
    }
    public void removeQueen(int i, int j) {
        cols[j] = 0;
        mainDiag[i - j + n - 1] = 0;
        secondDiag[i + j] = 0;
        queens[i] = 0;
    }

    // 校验
    public boolean check(int i, int j) {
        int sum = mainDiag[i - j + n - 1] + cols[j] + secondDiag[i + j];
        return sum == 0;
    }

    public void backtrack(int i) {
        for(int j = 0; j < n; j++) {
            if(check(i, j)) {
                placeQueen(i, j);
                if(i == n-1) {
                    addSolution();
                } else{
                    backtrack(i+1);
                }
                removeQueen(i, j);
            } 
            
        }
    }
    public void addSolution() {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == queens[i]) {
                    builder.append("Q");
                } else{
                    builder.append(".");
                }
            }
            list.add(builder.toString());
        }
        output.add(list);
    }

}
