package 动态规划.分割回文串2;

import java.util.Arrays;

//https://leetcode-cn.com/problems/palindrome-partitioning-ii/
public class Solution {
    boolean[][] f;
    int n;
    int ans;
    public int minCut(String s) {
        n = s.length();
        f = new boolean[n][n];
        for(int i = 0; i < n; ++i){
            Arrays.fill(f[i], true);
        }
        //判断是否是回文串
        for(int i = n-1; i >= 0; --i){
            for(int j = i; j < n; ++j){
                f[i][j] = s.charAt(i) == s.charAt(j) && f[i+1][j-1];
            }
        }
        int[] m = new int[n]; //用来纪录[0, ... ,i] 需要分割的最小次数
        Arrays.fill(m, Integer.MAX_VALUE);
        for(int i = 0; i < n; ++i){
            if(f[0][i]) m[i] = 0;
            else {
                for(int j = i-1; j > 0; --j){
                    if(f[j+1][i]) m[i] = Math.min(m[i], m[j]+1);
                }
            }
        }
        return m[n-1];
    }

}
