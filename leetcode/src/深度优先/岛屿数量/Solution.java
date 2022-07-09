package 深度优先.岛屿数量;

class Solution {
    int n, m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int cnt = 0;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(grid[i][j] == '1'){ //返现岛屿进入dfs cnt += 1
                    cnt += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    private void dfs(char[][] grid, int r, int c) {
        if(!inArea(r, c)) { //如果越界
            return ;
        }else if(grid[r][c] == '0') { //是海洋
            return ;
        }else if(grid[r][c] != '1') { //已经访问过
            return ;
        }else {
            grid[r][c] = '2'; //标记为访问过
            dfs(grid, r-1, c);
            dfs(grid, r+1, c);
            dfs(grid, r, c-1);
            dfs(grid, r, c+1);
        }
    }

    public boolean inArea(int r, int c){
        if(0 <= r && r < n && 0 <= c && c < m){
            return true;
        }else {
            return false;
        }
    }
}
