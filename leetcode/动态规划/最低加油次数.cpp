//https://leetcode.cn/problems/minimum-number-of-refueling-stops/submissions/
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[][] dp = new long[n+1][n+1];
        for(int i = 0; i <= n; ++i){
            dp[i][0] = startFuel; //如果一次有都不加，跑的距离就是startFuel这么远，不论经过多少加油站
        }
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= i; ++j){
                if(stations[i-1][0] <= dp[i-1][j]){  //如果前一站i-1能够到达第i站stations[i-1][0]
                    dp[i][j] = dp[i-1][j]; //可以选择不加油
                }
                if(stations[i-1][0] <= dp[i-1][j-1]){ 
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + stations[i-1][1]);  //这里的stations[i-1][1]表示是在第i个站加油，因为i从1开始
                }//跑的最远的距离要从不加油和加油跑的距离中取最大值 注意如果在前i个站加j次油而第i个站加了一次油，则前i-1个站只能加j-1次油
            }
        }
        for(int j = 0; j <= n; ++j){
            if(dp[n][j] >= target){
                return j;
            }
        }
        return -1;
    }
}
