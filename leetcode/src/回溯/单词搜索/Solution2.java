package 回溯.单词搜索;

import java.util.Arrays;

public class Solution2 {
    public int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean[][] vis;
    public boolean exist(char[][] board, String word) {
        vis = new boolean[board.length][board[0].length];
        boolean res = false;
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(board[i][j] == word.charAt(0)){
                    res = dfs(board, word, 0, i, j);
                    if(res) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int pos, int x, int y){
        if(board[x][y] != word.charAt(pos)) return false;
        if(pos == word.length()-1) {
            return true;
        }
        else{
            vis[x][y] = true;
            boolean res = false;
            for(int[] a : dir){
                int newX = x + a[0];
                int newY = y + a[1];
                if(0 <= newX && newX < board.length && 0 <= newY && newY < board[0].length){
                    if(!vis[newX][newY]){
                        boolean flag = dfs(board, word, pos+1, newX, newY);
                        if(flag) {
                            res = true;
                            break;
                        }
                    }
                }
            }
            vis[x][y] = false;
            return res;
        }
    }
}
