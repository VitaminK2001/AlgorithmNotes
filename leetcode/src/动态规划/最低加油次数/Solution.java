package 动态规划.最低加油次数;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[][] dp = new long[n+1][n+1];
        dp[0][0] = startFuel; //dp[i][j]表示从0~i-1个加油站加j次油能够跑的最远距离
        for(int i = 1; i <= n; ++i){
            for(int j = 0; j <= i; ++j){

            }
        }
        for(int i = 1; i <= n; ++i){
            for(int j = 0; j <= i; ++j){
                if(dp[i][j] > stations[n-1][0]){
                    return j;
                }
            }
        }
        return -1;
    }
}
