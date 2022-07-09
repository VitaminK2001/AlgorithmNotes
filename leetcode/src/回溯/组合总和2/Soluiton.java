package 回溯.组合总和2;
import java.util.*;
public class Soluiton {
    List<int[]> freq = new ArrayList<>();
    List<Integer> sequence = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for(int num : candidates){
            int size = freq.size();
            if(freq.isEmpty()||num != freq.get(size-1)[0]){
                freq.add(new int[]{num, 1});
            }else {
                ++freq.get(size-1)[1];
            }
        }
        dfs(0, target);
        return res;
    }
    public void dfs(int pos, int rest){
        if(rest == 0){
            res.add(new ArrayList<>(sequence));
            return;
        }
        if(pos == freq.size() || rest < freq.get(pos)[0]){
            return;
        }
        dfs(pos+1, rest); //如果这一系列重复的数都不选
        int most = Math.min(freq.get(pos)[1], rest/freq.get(pos)[0]);
        for(int i = 1; i <= most; ++i){ //选其中的一个或几个
            sequence.add(freq.get(pos)[0]);
            dfs(pos, rest-i*freq.get(pos)[0]); //选完之后pos不变因为pos指向的数还没有选完
        }
        //如果pos指向的数选完了，而且当前层没有在上面两条return语句返回，
        //说明不满足情况，则退出该层之前将选的数pop掉，注意是全部pop掉
        //因为这个pos指向的所有数已经没有价值了，可能的情况全部考虑完了
        //走到这里一定是这个数的全部都选完了，既然这样就相当于在这一层的所有情况都考虑完了
        for(int i = 1; i <= most; ++i){
            sequence.remove(sequence.size()-1);
        }
    }
}
