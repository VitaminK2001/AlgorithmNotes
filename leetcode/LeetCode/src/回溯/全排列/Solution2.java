package 回溯.全排列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> output = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int num : nums){
            output.add(num);
        }
        dfs(output, res, 0, nums);
        return res;
    }
    public void dfs(List<Integer> output, List<List<Integer>> res, int first, int[] nums){
        if(first == nums.length){
            res.add(new ArrayList<>(output));
        }
        for(int i = first; i <= nums.length; ++i){ //i=first是不变换位置也是一种排列
            Collections.swap(output, first, i);
            dfs(output, res, first+1, nums);
            Collections.swap(output, first, i); //换回来
        }
    }
}

