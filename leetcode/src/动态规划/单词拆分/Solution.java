package 动态规划.单词拆分;

import java.util.*;
//https://leetcode-cn.com/problems/word-break/
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict){
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); ++i){
            for(int j = 0; j < i; ++j){
                if(dp[j] && wordDictSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break; //只要找到一个就可以证明是对的
                }
            }
        }
        return dp[s.length()];
    }
}
