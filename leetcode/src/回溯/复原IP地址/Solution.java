package 回溯.复原IP地址;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int segment = 4;
    List<String> res = new ArrayList<>();
    int[] seg = new int[segment];
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return res;
    }
    void dfs(String s, int id, int start){
        if(id == segment){
            if(start == s.length()){
                StringBuffer ans = new StringBuffer();
                for(int i = 0; i < segment; ++i){
                    ans.append(seg[i]);
                    if(i != segment -1){
                        ans.append(".");
                    }
                }
                res.add(ans.toString());
            }
            return;
        }
        if(start == s.length()){
            return;
        }
        if(s.charAt(start) == '0'){
            seg[id] = 0;
            dfs(s, id+1, start+1);
            return;
        }
        int cont = 0;
        for(int end = start; end < s.length(); ++end){
            cont = cont * 10 + (s.charAt(end)-'0');
            if(0 < cont && cont <= 0xff){
                seg[id] = cont; //说明这种情况就是对的，没必要撤销，回溯过后会自动撤销，因为重新赋值了
                dfs(s, id+1, end+1);
            }else{
                break;
            }
        }
    }
}
