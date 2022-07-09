package 动态规划.不同路径2;

import java.util.Arrays;

//https://leetcode-cn.com/problems/unique-paths-ii/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] dp = new int[m];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                    continue;
                }

                if(j-1 >= 0 && obstacleGrid[i][j-1] == 0){
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[m-1];
    }
}
