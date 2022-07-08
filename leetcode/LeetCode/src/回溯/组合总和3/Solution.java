package 回溯.组合总和3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(ans, path, 1, 0, n, k);
        return ans;
    }
    void dfs(List<List<Integer>> ans, Deque<Integer> path, int begin, int depth, int n, int k){
        if(n < 0) return;
        if(n == 0 && depth == k){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin; i <= 9; ++i){
            path.offerLast(i);
            dfs(ans, path, i+1, depth+1, n-i, k+1);
            path.removeLast();
        }
    }
}

class Main{
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> ans = new ArrayList<>();
        ans = s.combinationSum3(3, 7);
        for(List<Integer> a : ans){
            for(int num : a){
                System.out.println(num);
            }
        }
    }
}
