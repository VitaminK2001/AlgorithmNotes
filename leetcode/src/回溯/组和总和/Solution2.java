package 回溯.组和总和;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> combine = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(combine, candidates, 0, target, res);
        return res;
    }

    public void dfs(List<Integer> combine, int[] candidates, int idx, int target, List<List<Integer>> res){
        if(idx == candidates.length){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(combine));
            return;
        }
        dfs(combine, candidates, idx+1, target, res);
        if(target-candidates[idx] >= 0){ //如果没有设置等于则不可能有target == 0这一点
            combine.add(candidates[idx]);
            dfs(combine, candidates, idx, target-candidates[idx], res);
            combine.remove(combine.size()-1);
        }
    }
}
class Main{
    public static void main(String[] args) {
        int[] num = new int[]{2,3,6,7};
        Solution2 s = new Solution2();
        s.combinationSum(num, 7);
    }
}
