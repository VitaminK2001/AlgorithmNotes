package 回溯.全排列2;
import java.util.*;
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int len = nums.length;
        if(len == 0) return res;
        Arrays.sort(nums);
        boolean[] used = new boolean[len];
        dfs(res, path, 0, nums, used);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> path,
                    int depth, int[] nums, boolean[] used){
        if(depth == nums.length){
            res.add(new ArrayList<>(path)); //因为java传的是引用path最终会变成null
        }
        for(int i = 0; i < nums.length; ++i){
            if(used[i]) continue;
            if(i>0&&nums[i]==nums[i-1]&&!used[i-1]) continue;
            used[i] = true;
            path.add(nums[i]);
            dfs(res, path, depth+1, nums, used);
            used[i] = false;
            path.remove(path.size()-1);
        }
    }
}

class Main{
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> res = s.permuteUnique(new int[]{1,1,2});
        Iterator<List<Integer>> it = res.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
