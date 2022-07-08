package 最大子序和;

public class Solution {
    int maxSubArray(int[] nums){
        int result = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < nums.length; ++i){
            count = 0;
            for(int j = i; j < nums.length; ++j){
                count += nums[j];
                result = count > result ? count : result;
            }
        }
        return result;
    }
}
class Solution2{ //动态规划
    int maxSubArray(int[] num){
        int len = num.length;
        if(len == 0) return 0; /*注意*/
        int[] dp = new int[len];
        int result = num[0];
        dp[0] = num[0];
        for(int i = 1; i < len; ++i){
            if (dp[i-1]+num[i] < num[i]) dp[i] = num[i];
            else dp[i] = dp[i-1] + num[i];
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
