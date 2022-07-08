package 动态规划.岛屿数量;

public class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int r = grid.length;
        int c = grid[0].length;
        int numIslands = 0;
        for(int i = 0; i < r; ++i){
            for(int j = 0; j < c; ++j){
                if(grid[i][j]=='1'){
                    numIslands++;
                    dfs(grid,r,c);
                }
            }
        }
        return numIslands;
    }
    boolean inArea(int r, int c, char[][] grid){
        return (0 <= r && r < grid.length) &&
                (0 <= c && c < grid[0].length);
    }
    void dfs(char[][] grid, int r, int c){
        if(!inArea(r, c, grid)) return;
//        if(grid[r][c]!='1') return;
        if(grid[r][c]=='0') return;
        grid[r][c] = '2';
        dfs(grid, r+1, c);
        dfs(grid, r, c+1);
        dfs(grid, r-1, c);
        dfs(grid, r, c-1);
    }
}
//
//    public int numIslands(char[][] grid) {
//        if(grid==null || grid.length==0) return 0;
//        int r = grid.length;
//        int c = grid[0].length;
//        int numIslands = 0;
//        for(int i = 0; i < r; ++i){
//            for(int j = 0; j < c; ++j){
//                if(grid[i][j]=='1'){
//                    numIslands++;
//                    dfs(grid,r,c);
//                }
//            }
//        }
//        return numIslands;
//    }
//    boolean inArea(int r, int c, char[][] grid){
//        return (0 <= r && r <= grid.length) &&
//                (0 <= c && c <= grid[0].length);
//    }
//    void dfs(char[][] grid, int r, int c){
//        if(!inArea(r, c, grid)) return;
////        if(grid[r][c]!='1') return;
//        if(grid[r][c]=='0') return;
//        grid[r][c] = '2';
//        dfs(grid, r+1, c);
//        dfs(grid, r, c+1);
//        dfs(grid, r-1, c);
//        dfs(grid, r, c-1);
//    }
