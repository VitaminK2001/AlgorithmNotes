package 回溯.组合总和4;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/combination-sum-iv/
public class Solution {
    public int combinationSum4(int[] nums, int target){
        int [] dp = new int[target+1]; //dp[i]表示总和为i的组合数
        dp[0] = 1;
        for(int i = 1; i <= target; ++i){
            for(int num : nums){
                if(i >= num){
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}

