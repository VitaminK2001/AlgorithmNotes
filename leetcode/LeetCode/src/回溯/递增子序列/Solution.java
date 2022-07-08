package 回溯.递增子序列;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/increasing-subsequences/
public class Solution {
    List<Integer> tmp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums){
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    void dfs(int cur, int last, int[] nums){
        //cur是当前的位置，last表示当前的最大值
        if(cur == nums.length){
           if(tmp.size() >= 2){
               ans.add(new ArrayList<>(tmp)); //不能直接加tmp会是引用
           }
           return ;
        }
        if(nums[cur] >= last){
            tmp.add(nums[cur]);
            dfs(cur+1, nums[cur], nums);
            tmp.remove(tmp.size()-1);
        }
        if(nums[cur]!=last){
            dfs(cur+1, last, nums); //如果小于或者大于的情况就不选这个元素，体现在last不变
        }
    }
}
