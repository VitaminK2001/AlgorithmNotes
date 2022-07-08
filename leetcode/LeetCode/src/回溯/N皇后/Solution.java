package 回溯.N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    //先扩展可能性
    //再画棋盘
    int[] c;
    List<List<String>> res = new ArrayList<>();
//    List<String> path = new ArrayList<>(); //path建错位置了
    public List<List<String>> solveNQueens(int n) {
        c = new int[n]; //存放每一行的棋子情况
        Arrays.fill(c, -1);
        dfs(n, 0);
        return res;
    }
    public boolean check(int[] c, int row, int col){
        for(int i = 0; i < row; ++i){
            if(c[i] == col) return false; //同一列
            if(Math.abs(i-row) == Math.abs(c[i]-col)) return false;
        }
        return true;
    }
    void dfs(int n, int row){
        if(row > n) return;
        if(row == n) { //开始画棋盘
            List<String> path = new ArrayList<>();
            for(int i = 0; i < row; ++i){
                StringBuffer s = new StringBuffer();
                for(int j = 0; j < row; ++j){
                    if(c[i]==j){
                        s.append("Q");
                    }else{
                        s.append(".");
                    }
                }
                path.add(s.toString());
            }
            res.add(path);
            return;
        }
        //继续扩展可能性
        for(int j = 0; j < n; ++j){
            boolean ok = check(c, row, j);
            if(!ok) continue;
            else{
                c[row] = j;
                dfs(n, row+1);
                c[row] = -1;
            }

        }
    }
}
class Main{
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> res = new ArrayList<>();
        res = s.solveNQueens(4);

    }
}
