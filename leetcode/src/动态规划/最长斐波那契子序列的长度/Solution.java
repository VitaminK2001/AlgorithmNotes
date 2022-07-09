package 动态规划.最长斐波那契子序列的长度;

import java.util.HashMap;

//https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i < n; ++i){
            for(int j = i+1; j < n; ++j) {
                dp[i][j] = 2; //初始值都是2
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; ++i){
            map.put(arr[i], i);
        }
        int MAX = 0;
        for(int i = 0; i < n; ++i){
            for(int j = i+1; j < n; ++j) {
                int diff = arr[j]-arr[i];
                if(map.containsKey(diff)){
                    dp[i][j] = Math.max(dp[i][j], dp[map.get(diff)][i]+1);
                }
                MAX = Math.max(MAX, dp[i][j]);
            }
        }
        return MAX > 2 ? MAX : 0;
    }
}
