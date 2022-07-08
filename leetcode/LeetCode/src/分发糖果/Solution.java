package 分发糖果;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length-1;
        int result = 0;
        for(int i = g.length-1; i >= 0; --i){
            if(index >= 0 && s[index] >= g[i]){
                result++;
                index--;
            }
        }
        return result;
    }
}
class Solution2{
    public int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        for(int i = 0; i <= s.length-1; ++i){
            if(index <= g.length-1 && s[i] >= g[index]){
                index++;
            }
        }
        return index;
    }
}
