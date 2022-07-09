package 动态规划.整数拆分;
//https://leetcode-cn.com/problems/integer-break/
//对于拆分类的问题都有拆分或者不拆分两个选择
public class Solution {
    public int integerBreak(int n){
        int[] dp = new int[n+1];
        for(int i = 2; i <= n; ++i){
            int curMax = 0;
            for(int j = 0; j < i; ++j){
                curMax = Math.max(curMax, Math.max(j * (i-j), j * dp[i-j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
