package 回溯.单词搜索2;

import java.util.*;

public class Solution {
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        Trie now = new Trie();
        for(String word : words){
            now.insert(word);
        }
        Set<String> ans = new HashSet<>();
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                dfs(board, now, ans, i, j);
            }
        }
        return new ArrayList<>(ans);
    }
    public void dfs(char[][] board, Trie now, Set<String> ans, int i, int j){
        if(!now.children.containsKey(board[i][j])){
            return ;
        }
        char ch = board[i][j];
        now = now.children.get(ch);
        if(!now.word.equals("")){
            ans.add(now.word);
        }
        board[i][j] = '#';
        for(int[] dir : dirs){
            int i2 = i + dir[0];
            int j2 = j + dir[1];
            if(0 <= i2 && i2 < board.length && 0 <= j2 && j2 < board[0].length){
                dfs(board, now, ans, i2, j2);
            }
        }
        board[i][j] = ch;
    }
}
