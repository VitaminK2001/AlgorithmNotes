package 回溯.单词搜索;

import java.util.Arrays;

//https://leetcode-cn.com/problems/word-search/
public class Solution {
    static int[][] pos = new int[4][2];
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean ok = false;
        pos = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                ok = dfs(board, word, i, j, 0, visited);
                if(ok) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, String word, int x, int y, int post, boolean[][] visited){
        visited[x][y] = true;
        boolean result = false;
        if(word.charAt(post) == board[x][y]){
            if(post == word.length()-1) {
                result = true; //搜到头了
            }
            //没搜到头
            else{
                for(int[] a : pos){
                    int newX = x + a[0];
                    int newY = y + a[1];
                    boolean flag = false;
                    if(0 <= newX && newX < board.length && 0 <= newY && newY < board[0].length){
                        if(!visited[newX][newY]){
                            flag = dfs(board, word, newX, newY, post + 1, visited);
                            if(flag) { //返回的是这一层的flag是否正确
                                result = true; //将这一层的flag设置为true
                                break; //不用搜其他的可能
                            }
                        }
                    }
                }
            }
        }
        visited[x][y] = false;
        return result; //这样就返回一次改变的结果
    }
}
class Main{
    public static void main(String[] args) {
        char[][] board = new char[3][4];
        board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String s = "ABCCED";
        Solution a = new Solution();
        a.exist(board, s);

    }
}