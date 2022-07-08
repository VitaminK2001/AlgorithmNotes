package 动态规划.不同路径;
//https://leetcode-cn.com/problems/unique-paths/
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 1; i < m; ++i){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; ++j){
            dp[0][j] = 1;
        }
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
