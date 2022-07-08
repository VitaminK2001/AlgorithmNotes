package 动态规划.分割等和子集;

import java.util.Arrays;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int a : nums){
            sum += a;
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        int len = nums.length;
        boolean [][]dp = new boolean[len+1][target+1]; //用前i个数凑j是否可以凑满
        for(int i = 1; i <= len; ++i){
            dp[i][0] = true; //如果target为0一定可以凑满，背包没有空间相当于装满
        }
        for(int i = 1; i <= len; ++i){
            for(int j = 1; j <= target; ++j){
                if(j-nums[i-1]>=0){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j]; //由于不能重复用
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len][target];
    }
}


