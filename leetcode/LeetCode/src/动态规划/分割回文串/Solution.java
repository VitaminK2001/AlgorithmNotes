package 动态规划.分割回文串;

import java.util.*;

public class Solution {
    boolean[][] f;
    List<List<String>> ret = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for(int i = 0; i < n; ++i){
            Arrays.fill(f[i], true);
        }
        for(int i = n-1; i >=0; --i){
            for(int j = i+1; j < n; ++j){
                f[i][j] = (s.charAt(i)==s.charAt(j)) && f[i+1][j-1];
            }
        }
        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i){
        if(i==n){
            ret.add(new ArrayList<>(ans));
            return;
        }
        for(int j = i; j < n; ++j){
            if(f[i][j]){
                ans.add(s.substring(i, j+1));
                //在每一个可能的回文串后面开始找紧接着的回文串
                //最终将每个位置可能的划分都添加到ans中
                dfs(s, j+1);
                //放弃其中一种选择就将ans的当前一个pop掉
                ans.remove(ans.size()-1);
            }
        }
    }
}


class Solution2{
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s == null){
            return new ArrayList<>();
        }
        else if(s.length() == 1){
            List<String> partition = new ArrayList<>();
            partition.add(s);
            result.add(partition);
            return result;
        }else {
            partition(s, 0, new ArrayList<>(), s.substring(0,1));
            return result;
        }
    }

    private void partition(String s, int pos, List<String> partitions, String curPartition) {
        if(pos == s.length()-1){
            if(isPalindrome(curPartition)){
                List<String> newPartition = new ArrayList<>(Arrays.asList(new String[partitions.size()]));
                Collections.copy(newPartition, partitions);
                newPartition.add(curPartition);
                result.add(newPartition);
            }
            return;
        }
        if(isPalindrome(curPartition)){
            List<String> newPartition = new ArrayList<>(Arrays.asList(new String[partitions.size()]));
            Collections.copy(newPartition, partitions);
            newPartition.add(curPartition);
            partition(s, pos+1, newPartition, s.substring(pos+1, pos+2));
        }
        partition(s, pos+1, partitions, curPartition+s.substring(pos+1, pos+2));
    }

    private boolean isPalindrome(String str) {
        if(str == null || str.length() < 2){
            return true;
        }
        for(int i = 0; i < str.length()/2; ++i){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
