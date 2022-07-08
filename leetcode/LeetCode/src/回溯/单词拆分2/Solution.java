package 回溯.单词拆分2;
//https://leetcode-cn.com/problems/word-break-ii/solution/dan-ci-chai-fen-ii-by-leetcode-solution/
//像在一个集合中找一个元素是否存在的题目首先考虑哈希表
import java.util.*;
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict){
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();

        //动态规划计算是否有节
        //dp[i]表示长度为i的字符串是否可以拆分
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int right = 1; right <= len; ++right){
            for(int left = right; left >= 0; --left){
                //dp[left]不包含left，substring不包含right
                if(wordDict.contains(s.substring(left, right))&& dp[left]){
                    dp[right] = true;
                    break; //找到一种拆分方案就可以
                }
            }
        }

        //回溯搜索所有的解
        List<String> res = new ArrayList<>();
        if(dp[len]){
            Deque<String> path = new ArrayDeque<>();
            dfs(s, len, wordSet, res, path, dp);
            return res;
        }
        return res;
    }
    void dfs(String s, int len, Set<String> wordSet, List<String> res, Deque<String> path, boolean[] dp){
        if(len == 0){
            res.add(String.join(" ", path));
            return;
        }
        for(int i = len-1; i >= 0; --i){
            String suffix = s.substring(i, len);
            if(wordSet.contains(suffix)&&dp[i]){
                path.addFirst(suffix);
                dfs(s, i, wordSet, res, path, dp);
                path.removeFirst();
            }
        }
    }
}
