package 回溯.组和总和;

import java.util.*;

//https://leetcode-cn.com/problems/combination-sum/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int len = candidates.length;
        if(len == 0) return res;
        Arrays.sort(candidates);
        dfs(candidates, res, path, 0, len, target);
        return res;
    }
    private void dfs(int[] candidates, List<List<Integer>> res, Deque<Integer> path,
                     int begin, int n, int target){
        if(target==0) res.add(new ArrayList<>(path));

        for(int i = begin; i < n; ++i){
            if(target-candidates[i]<0) break; //排序之后，如果i都小于零，那么i之后这一层没必要搜索了
            path.offerLast(candidates[i]);
            dfs(candidates, res, path, i, n, target-candidates[i]);
            path.removeLast();
        }
    }
}
