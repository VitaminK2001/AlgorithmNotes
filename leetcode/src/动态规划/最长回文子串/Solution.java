package 动态规划.最长回文子串;

public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; ++i){
            dp[i][i] = true;
        }
        int i = 0;
        int j = 0;
        int maxLen = 0;
        int start = 0;
        for(i = len-1; i >= 0; --i){
            for(j = i; j < len; ++j){
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i<3) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }else {
                    dp[i][j] = false;
                }
            }
            if(dp[i][j] && (j-i+1 > maxLen)) {
                maxLen = j-i+1;
                start = i;
            }
        }
        return s.substring(start, start+maxLen);
    }
}
