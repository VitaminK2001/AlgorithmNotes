package 动态规划.零钱兑换;

import java.util.Arrays;
import java.util.List;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int kinds = coins.length;
//        int [][] dp = new int[kinds+1][amount+1];
//        int [][] dp = new int[amount+1][kinds+1];
//        for(int i = 0; i <= kinds; ++i){
//            dp[i][0] = 1;
//        }
//        for(int j = 0; j <= kinds; ++j){
//            dp[0][j] = 1;
//        }
//        for(int i = 1; i <= kinds; ++i){
//            for(int j = 1; j <= amount; ++j){
//                if(j-coins[i-1]>=0) {
//                    dp[i][j] = dp[i][j-coins[i-1]]+dp[i-1][j];
//                }else {
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }

//        for(int i= 1; i <= amount; ++i){
//            for(int j = 1; j <= kinds; ++j){
//                if(i-coins[j-1]>=0){
//                    dp[i][j] = dp[i-coins[j-1]][j]+dp[i][j-1];
//                }else {
//                    dp[i][j] = dp[i][j-1];
//                }
//            }
//        }
        int [] dp = new int[amount];
        for(int j = 1; j <= kinds; ++j){
            for(int i = 0; i < amount; ++i){ //重复amount轮
                if(i-coins[j-1]>=0){
                    dp[i] = dp[i-coins[j-1]]+dp[i];
                }
            }
        }

//        return dp[kinds][amount];
//        return dp[amount][kinds];
        return dp[amount-1];
    }
}
