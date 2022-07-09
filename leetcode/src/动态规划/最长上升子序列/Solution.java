package 动态规划.最长上升子序列;
//https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
//关键在于不从前往后看，从后往前看，找到转换的状态

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[] dp = new int[len];
        int maxAns = 1;
        dp[0] = 1;
        for(int i = 1; i < len; ++i){
            for(int j = 0; j < i; ++j){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        for(int i = 0; i < len; ++i){
            if(dp[i] > maxAns) maxAns =dp[i];
        }
        return maxAns;
    }
}
