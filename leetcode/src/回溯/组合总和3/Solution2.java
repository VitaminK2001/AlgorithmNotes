package 回溯.组合总和3;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<List<Integer>> res;
    List<Integer> combine;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        combine = new ArrayList<>();
        for(int mask = 0; mask < (1<<9); ++mask){
            if(check(mask, k, n)){
                res.add(new ArrayList<>(combine));
            }
        }
        return res;
    }

    private boolean check(int mask, int k, int n) {
        combine.clear();
        for(int i = 0; i < 9; ++i){
            if((mask & (1 << i)) != 0){
                combine.add(i+1);
            }
        }
        if(combine.size() != k){
            return false;
        }
        int sum = 0;
        for(int num : combine){
            sum += num;
        }
        return sum == n;
    }
}
