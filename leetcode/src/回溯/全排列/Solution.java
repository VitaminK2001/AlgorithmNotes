package 回溯.全排列;
import java.util.*;
//https://leetcode-cn.com/problems/permutations/submissions/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List path = new ArrayList();
        if(len == 0) return res;
        int depth = 0;
        boolean[] used = new boolean[len];
        dfs(nums, depth, used, res, path);
        return res;
    }
    public void dfs(int[] nums, int depth, boolean[] used,
                    List<List<Integer>> res, List path){
        if(depth==nums.length){
            res.add(new ArrayList<>(path));
        }
        for(int i = 0; i < nums.length; ++i){
            if(!used[i]){
                path.add(used[i]);
                used[i] = true;
                dfs(nums, depth+1, used, res, path);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}