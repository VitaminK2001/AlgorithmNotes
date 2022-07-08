package 深度优先.岛屿的周长;

class Solution {
    int n, m;
    public int islandPerimeter(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == 1){
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }
    public int dfs(int[][] grid, int r, int c){
        if(!inArea(r, c)) { //越界
            return 1;
        }
        else if(grid[r][c] == 0) { //没有越界，是海洋
            return 1;
        }else if(grid[r][c] != 1) { //没有越界，是已经遍历过的陆地
            return 0;
        }else {
            grid[r][c] = 2; //如果是没有遍历过的格子，标记为遍历过
            return dfs(grid, r-1, c)+
                    dfs(grid, r+1, c)+
                    dfs(grid, r, c-1)+
                    dfs(grid, r, c+1);  //返回周围所有格子周长
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
